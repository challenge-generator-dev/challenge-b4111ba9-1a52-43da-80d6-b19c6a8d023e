package com.pragma.payments.application.usecase;

import com.pragma.payments.application.dto.PaymentRequest;
import com.pragma.payments.application.dto.PaymentResponse;
import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.domain.port.PaymentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentUseCase {

    private static final Logger logger = LoggerFactory.getLogger(PaymentUseCase.class);
    private static final String PAYMENT_SERVICE = "paymentService";

    private final PaymentRepository paymentRepository;

    public PaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "processPaymentFallback")
    @Retry(name = PAYMENT_SERVICE)
    @RateLimiter(name = PAYMENT_SERVICE)
    public PaymentResponse processPayment(PaymentRequest request) {
        logger.info("Iniciando procesamiento de pago para cuenta: {} amount: {}", 
                request.accountId(), request.amount());

        validatePaymentRequest(request);

        Payment payment = new Payment(
            UUID.randomUUID(),
            request.accountId(),
            request.amount(),
            request.currency(),
            request.recipientAccount(),
            LocalDateTime.now(),
            PaymentStatus.PENDING
        );

        Payment savedPayment = paymentRepository.save(payment);
        
        boolean processed = executePaymentProcessing(savedPayment);
        
        if (processed) {
            savedPayment.markAsCompleted();
            logger.info("Pago completado exitosamente: {}", savedPayment.getId());
        } else {
            savedPayment.markAsFailed("Procesamiento fallido");
            logger.warn("Pago marcado como fallido: {}", savedPayment.getId());
        }
        
        Payment updatedPayment = paymentRepository.save(savedPayment);
        return PaymentResponse.fromDomain(updatedPayment);
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "getPaymentByIdFallback")
    public PaymentResponse getPaymentById(UUID paymentId) {
        logger.info("Consultando pago con ID: {}", paymentId);
        
        return paymentRepository.findById(paymentId)
                .map(PaymentResponse::fromDomain)
                .orElseThrow(() -> new PaymentNotFoundException("Pago no encontrado: " + paymentId));
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "getPaymentsByAccountFallback")
    public List<PaymentResponse> getPaymentsByAccount(String accountId) {
        logger.info("Consultando pagos para cuenta: {}", accountId);
        
        return paymentRepository.findByAccountId(accountId)
                .stream()
                .map(PaymentResponse::fromDomain)
                .collect(Collectors.toList());
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "getPaymentsByStatusFallback")
    public List<PaymentResponse> getPaymentsByStatus(PaymentStatus status) {
        logger.info("Consultando pagos con estado: {}", status);
        
        return paymentRepository.findByStatus(status)
                .stream()
                .map(PaymentResponse::fromDomain)
                .collect(Collectors.toList());
    }

    private void validatePaymentRequest(PaymentRequest request) {
        if (request.accountId() == null || request.accountId().isBlank()) {
            throw new InvalidPaymentException("Account ID es requerido");
        }
        if (request.amount() == null || request.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPaymentException("El monto debe ser mayor a cero");
        }
        if (request.currency() == null || request.currency().isBlank()) {
            throw new InvalidPaymentException("Currency es requerido");
        }
        if (request.recipientAccount() == null || request.recipientAccount().isBlank()) {
            throw new InvalidPaymentException("Recipient account es requerido");
        }
    }

    private boolean executePaymentProcessing(Payment payment) {
        logger.debug("Ejecutando lógica de procesamiento para pago: {}", payment.getId());
        
        if (payment.getAmount().compareTo(new BigDecimal("10000")) > 0) {
            logger.info("Monto mayor a 10000 requiere validación adicional");
        }
        
        return true;
    }

    private PaymentResponse processPaymentFallback(PaymentRequest request, Exception ex) {
        logger.error("Fallback activado para processPayment. Error: {}", ex.getMessage());
        return PaymentResponse.pending(
            UUID.randomUUID(),
            request.accountId(),
            request.amount(),
            request.currency(),
            request.recipientAccount()
        ).withFailureReason("Servicio temporalmente no disponible: " + ex.getMessage());
    }

    private PaymentResponse getPaymentByIdFallback(UUID paymentId, Exception ex) {
        logger.error("Fallback activado para getPaymentById. Error: {}", ex.getMessage());
        throw new PaymentServiceUnavailableException(
            "No se pudo obtener el pago. Servicio no disponible.");
    }

    private List<PaymentResponse> getPaymentsByAccountFallback(String accountId, Exception ex) {
        logger.error("Fallback activado para getPaymentsByAccount. Error: {}", ex.getMessage());
        throw new PaymentServiceUnavailableException(
            "No se pudieron obtener los pagos. Servicio no disponible.");
    }

    private List<PaymentResponse> getPaymentsByStatusFallback(PaymentStatus status, Exception ex) {
        logger.error("Fallback activado para getPaymentsByStatus. Error: {}", ex.getMessage());
        throw new PaymentServiceUnavailableException(
            "No se pudieron obtener los pagos por estado. Servicio no disponible.");
    }

    public static class PaymentNotFoundException extends RuntimeException {
        public PaymentNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidPaymentException extends RuntimeException {
        public InvalidPaymentException(String message) {
            super(message);
        }
    }

    public static class PaymentServiceUnavailableException extends RuntimeException {
        public PaymentServiceUnavailableException(String message) {
            super(message);
        }
    }
}