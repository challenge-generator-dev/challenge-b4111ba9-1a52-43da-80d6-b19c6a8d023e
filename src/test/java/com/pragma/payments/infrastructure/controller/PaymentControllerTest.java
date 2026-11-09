package com.pragma.payments.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.payments.application.dto.PaymentRequest;
import com.pragma.payments.application.dto.PaymentResponse;
import com.pragma.payments.application.usecase.PaymentUseCase;
import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.infrastructure.config.GlobalExceptionHandler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
@Import(GlobalExceptionHandler.class)
@DisplayName("PaymentController - Tests de integración con Resilience4j")
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PaymentUseCase paymentUseCase;

    private Payment testPayment;
    private UUID paymentId;
    private PaymentRequest validRequest;

    @BeforeEach
    void setUp() {
        paymentId = UUID.randomUUID();
        testPayment = new Payment(
            paymentId,
            "ACC-12345",
            new BigDecimal("1000.00"),
            "USD",
            "REC-67890",
            LocalDateTime.now(),
            PaymentStatus.PENDING,
            null
        );

        validRequest = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("1000.00"),
            "USD",
            "REC-67890"
        );
    }

    @Test
    @DisplayName("Crear payment retorna 201 cuando la peticion es valida")
    void createPayment_WhenRequestIsValid_ReturnsCreated() throws Exception {
        PaymentResponse response = toResponse(testPayment);
        when(paymentUseCase.createPayment(any(PaymentRequest.class))).thenReturn(testPayment);

        mockMvc.perform(post("/api/v1/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validRequest)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(paymentId.toString()))
            .andExpect(jsonPath("$.accountId").value("ACC-12345"))
            .andExpect(jsonPath("$.amount").value(1000.00))
            .andExpect(jsonPath("$.status").value("PENDING"));

        verify(paymentUseCase, times(1)).createPayment(any(PaymentRequest.class));
    }

    @Test
    @DisplayName("Crear payment retorna 400 cuando el monto es negativo")
    void createPayment_WhenAmountIsNegative_ReturnsBadRequest() throws Exception {
        PaymentRequest invalidRequest = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("-100.00"),
            "USD",
            "REC-67890"
        );

        when(paymentUseCase.createPayment(any(PaymentRequest.class)))
            .thenThrow(new IllegalArgumentException("El monto debe ser mayor que cero"));

        mockMvc.perform(post("/api/v1/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Crear payment retorna 400 cuando la cuenta es vacia")
    void createPayment_WhenAccountIdIsEmpty_ReturnsBadRequest() throws Exception {
        PaymentRequest invalidRequest = new PaymentRequest(
            "",
            new BigDecimal("100.00"),
            "USD",
            "REC-67890"
        );

        mockMvc.perform(post("/api/v1/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Obtener payment por ID retorna 200 cuando existe")
    void getPaymentById_WhenExists_ReturnsOk() throws Exception {
        when(paymentUseCase.getPaymentById(paymentId)).thenReturn(Optional.of(testPayment));

        mockMvc.perform(get("/api/v1/payments/{id}", paymentId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(paymentId.toString()))
            .andExpect(jsonPath("$.accountId").value("ACC-12345"));

        verify(paymentUseCase, times(1)).getPaymentById(paymentId);
    }

    @Test
    @DisplayName("Obtener payment por ID retorna 404 cuando no existe")
    void getPaymentById_WhenNotExists_ReturnsNotFound() throws Exception {
        when(paymentUseCase.getPaymentById(paymentId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/payments/{id}", paymentId))
            .andExpect(status().isNotFound());

        verify(paymentUseCase, times(1)).getPaymentById(paymentId);
    }

    @Test
    @DisplayName("Obtener payments por cuenta retorna 200 con lista")
    void getPaymentsByAccountId_ReturnsOkWithList() throws Exception {
        List<Payment> payments = List.of(testPayment);
        when(paymentUseCase.getPaymentsByAccountId("ACC-12345")).thenReturn(payments);

        mockMvc.perform(get("/api/v1/payments")
                .param("accountId", "ACC-12345"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].accountId").value("ACC-12345"));

        verify(paymentUseCase, times(1)).getPaymentsByAccountId("ACC-12345");
    }

    @Test
    @DisplayName("Obtener payments por estado retorna 200 con lista")
    void getPaymentsByStatus_ReturnsOkWithList() throws Exception {
        List<Payment> payments = List.of(testPayment);
        when(paymentUseCase.getPaymentsByStatus(PaymentStatus.PENDING)).thenReturn(payments);

        mockMvc.perform(get("/api/v1/payments")
                .param("status", "PENDING"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].status").value("PENDING"));

        verify(paymentUseCase, times(1)).getPaymentsByStatus(PaymentStatus.PENDING);
    }

    @Test
    @DisplayName("Completar payment retorna 200 cuando existe")
    void completePayment_WhenExists_ReturnsOk() throws Exception {
        testPayment.markAsCompleted();
        when(paymentUseCase.completePayment(paymentId)).thenReturn(testPayment);

        mockMvc.perform(put("/api/v1/payments/{id}/complete", paymentId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("COMPLETED"));

        verify(paymentUseCase, times(1)).completePayment(paymentId);
    }

    @Test
    @DisplayName("Completar payment retorna 404 cuando no existe")
    void completePayment_WhenNotExists_ReturnsNotFound() throws Exception {
        when(paymentUseCase.completePayment(paymentId))
            .thenThrow(new RuntimeException("Payment no encontrado"));

        mockMvc.perform(put("/api/v1/payments/{id}/complete", paymentId))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Fallar payment retorna 200 con razon")
    void failPayment_WhenExists_ReturnsOk() throws Exception {
        testPayment.markAsFailed("Fondos insuficientes");
        when(paymentUseCase.failPayment(paymentId, "Fondos insuficientes"))
            .thenReturn(testPayment);

        mockMvc.perform(put("/api/v1/payments/{id}/fail", paymentId)
                .param("reason", "Fondos insuficientes"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("FAILED"));

        verify(paymentUseCase, times(1)).failPayment(paymentId, "Fondos insuficientes");
    }

    @Test
    @DisplayName("Eliminar payment retorna 204 cuando existe")
    void deletePayment_WhenExists_ReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/api/v1/payments/{id}", paymentId))
            .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Crear payment con CircuitBreaker retorna 503 cuando el servicio falla")
    void createPayment_WhenCircuitBreakerIsOpen_ReturnsServiceUnavailable() throws Exception {
        when(paymentUseCase.createPayment(any(PaymentRequest.class)))
            .thenThrow(new RuntimeException("Servicio no disponible"));

        mockMvc.perform(post("/api/v1/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validRequest)))
            .andExpect(status().isServiceUnavailable());
    }

    @Test
    @DisplayName("Obtener payments sin parametros retorna 400")
    void getPayments_WhenNoParams_ReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/v1/payments"))
            .andExpect(status().isBadRequest());
    }

    private PaymentResponse toResponse(Payment payment) {
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
}