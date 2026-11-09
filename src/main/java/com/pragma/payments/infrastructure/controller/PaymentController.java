package com.pragma.payments.infrastructure.controller;

import com.pragma.payments.application.dto.PaymentRequest;
import com.pragma.payments.application.dto.PaymentResponse;
import com.pragma.payments.application.usecase.PaymentUseCase;
import com.pragma.payments.domain.model.Payment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    
    private final PaymentUseCase paymentUseCase;

    public PaymentController(PaymentUseCase paymentUseCase) {
        this.paymentUseCase = paymentUseCase;
    }

    @PostMapping
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackProcessPayment")
    @Retry(name = "paymentServiceRetry")
    @RateLimiter(name = "paymentServiceRateLimiter")
    public ResponseEntity<PaymentResponse> processPayment(@Valid @RequestBody PaymentRequest request) {
        log.info("Procesando pago para cuenta: {}, monto: {} {}", 
                request.accountId(), request.amount(), request.currency());
        
        Payment payment = paymentUseCase.createPayment(
                request.accountId(),
                request.amount(),
                request.currency(),
                request.recipientAccount()
        );
        
        PaymentResponse response = mapToResponse(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackGetPayment")
    @Retry(name = "paymentServiceRetry")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable UUID id) {
        log.info("Consultando pago con ID: {}", id);
        
        Payment payment = paymentUseCase.getPaymentById(id);
        
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(mapToResponse(payment));
    }

    @GetMapping("/account/{accountId}")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackGetPaymentsByAccount")
    @Retry(name = "paymentServiceRetry")
    public ResponseEntity<List<PaymentResponse>> getPaymentsByAccount(@PathVariable String accountId) {
        log.info("Consultando pagos para cuenta: {}", accountId);
        
        List<Payment> payments = paymentUseCase.getPaymentsByAccountId(accountId);
        List<PaymentResponse> responses = payments.stream()
                .map(this::mapToResponse)
                .toList();
        
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Payment service is running");
    }

    private PaymentResponse mapToResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getAccountId(),
                payment.getAmount(),
                payment.getCurrency(),
                payment.getRecipientAccount(),
                payment.getCreatedAt(),
                payment.getStatus().name(),
                payment.getFailureReason()
        );
    }

    private ResponseEntity<PaymentResponse> fallbackProcessPayment(PaymentRequest request, Throwable t) {
        log.error("Fallback activado para processPayment. Razón: {}", t.getMessage());
        PaymentResponse errorResponse = new PaymentResponse(
                null,
                request.accountId(),
                request.amount(),
                request.currency(),
                request.recipientAccount(),
                null,
                "FAILED",
                "Servicio temporalmente no disponible: " + t.getMessage()
        );
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
    }

    private ResponseEntity<PaymentResponse> fallbackGetPayment(UUID id, Throwable t) {
        log.error("Fallback activado para getPayment con ID: {}. Razón: {}", id, t.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }

    private ResponseEntity<List<PaymentResponse>> fallbackGetPaymentsByAccount(String accountId, Throwable t) {
        log.error("Fallback activado para getPaymentsByAccount con cuenta: {}. Razón: {}", accountId, t.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}