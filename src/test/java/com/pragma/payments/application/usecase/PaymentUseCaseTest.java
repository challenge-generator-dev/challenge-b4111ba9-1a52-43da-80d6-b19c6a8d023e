package com.pragma.payments.application.usecase;

import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.domain.port.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("PaymentUseCase - Tests de unidad")
class PaymentUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentUseCase paymentUseCase;

    private Payment testPayment;
    private UUID paymentId;

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
    }

    @Test
    @DisplayName("Crear pago exitosamente cuando los datos son válidos")
    void createPayment_WhenDataIsValid_ReturnsCreatedPayment() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("1000.00"),
            "USD",
            "REC-67890"
        );

        Payment savedPayment = new Payment(
            paymentId,
            request.accountId(),
            request.amount(),
            request.currency(),
            request.recipientAccount(),
            LocalDateTime.now(),
            PaymentStatus.PENDING,
            null
        );

        when(paymentRepository.save(any(Payment.class))).thenReturn(savedPayment);

        Payment result = paymentUseCase.createPayment(request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(paymentId);
        assertThat(result.getAccountId()).isEqualTo(request.accountId());
        assertThat(result.getAmount()).isEqualByComparingTo(request.amount());
        assertThat(result.getStatus()).isEqualTo(PaymentStatus.PENDING);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    @DisplayName("Crear pago falla cuando el monto es negativo")
    void createPayment_WhenAmountIsNegative_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("-100.00"),
            "USD",
            "REC-67890"
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("monto");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Crear pago falla cuando el monto es cero")
    void createPayment_WhenAmountIsZero_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            BigDecimal.ZERO,
            "USD",
            "REC-67890"
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("mayor que cero");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Obtener pago por ID exitosamente")
    void getPaymentById_WhenExists_ReturnsPayment() {
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(testPayment));

        Optional<Payment> result = paymentUseCase.getPaymentById(paymentId);

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(paymentId);
        assertThat(result.get().getAccountId()).isEqualTo("ACC-12345");
        verify(paymentRepository, times(1)).findById(paymentId);
    }

    @Test
    @DisplayName("Obtener pago por ID cuando no existe retorna vacio")
    void getPaymentById_WhenNotExists_ReturnsEmpty() {
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        Optional<Payment> result = paymentUseCase.getPaymentById(paymentId);

        assertThat(result).isEmpty();
        verify(paymentRepository, times(1)).findById(paymentId);
    }

    @Test
    @DisplayName("Obtener pagos por cuenta exitosamente")
    void getPaymentsByAccountId_ReturnsListOfPayments() {
        Payment secondPayment = new Payment(
            UUID.randomUUID(),
            "ACC-12345",
            new BigDecimal("500.00"),
            "EUR",
            "REC-11111",
            LocalDateTime.now(),
            PaymentStatus.COMPLETED,
            null
        );

        when(paymentRepository.findByAccountId("ACC-12345"))
            .thenReturn(List.of(testPayment, secondPayment));

        List<Payment> result = paymentUseCase.getPaymentsByAccountId("ACC-12345");

        assertThat(result).hasSize(2);
        assertThat(result).extracting(Payment::getAccountId)
            .containsOnly("ACC-12345");
        verify(paymentRepository, times(1)).findByAccountId("ACC-12345");
    }

    @Test
    @DisplayName("Obtener pagos por estado exitosamente")
    void getPaymentsByStatus_ReturnsListOfPayments() {
        when(paymentRepository.findByStatus(PaymentStatus.PENDING))
            .thenReturn(List.of(testPayment));

        List<Payment> result = paymentUseCase.getPaymentsByStatus(PaymentStatus.PENDING);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(PaymentStatus.PENDING);
        verify(paymentRepository, times(1)).findByStatus(PaymentStatus.PENDING);
    }

    @Test
    @DisplayName("Completar pago exitosamente")
    void completePayment_WhenPaymentExists_MarksAsCompleted() {
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(testPayment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(testPayment);

        Payment result = paymentUseCase.completePayment(paymentId);

        assertThat(result.getStatus()).isEqualTo(PaymentStatus.COMPLETED);
        verify(paymentRepository, times(1)).findById(paymentId);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    @DisplayName("Completar pago falla cuando no existe")
    void completePayment_WhenPaymentNotExists_ThrowsException() {
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> paymentUseCase.completePayment(paymentId))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("no encontrado");

        verify(paymentRepository, times(1)).findById(paymentId);
        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Fallar pago exitosamente con razón")
    void failPayment_WhenPaymentExists_MarksAsFailed() {
        String failureReason = "Fondos insuficientes";
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(testPayment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(testPayment);

        Payment result = paymentUseCase.failPayment(paymentId, failureReason);

        assertThat(result.getStatus()).isEqualTo(PaymentStatus.FAILED);
        verify(paymentRepository, times(1)).findById(paymentId);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    @DisplayName("Validar que cuenta origen no este vacia")
    void createPayment_WhenAccountIdIsEmpty_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "",
            new BigDecimal("100.00"),
            "USD",
            "REC-67890"
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("cuenta");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Validar que cuenta destino no este vacia")
    void createPayment_WhenRecipientAccountIsEmpty_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("100.00"),
            "USD",
            ""
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("destino");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Validar que moneda sea valida")
    void createPayment_WhenCurrencyIsInvalid_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("100.00"),
            "INVALID",
            "REC-67890"
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("moneda");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    static class PaymentRequest {
        private final String accountId;
        private final BigDecimal amount;
        private final String currency;
        private final String recipientAccount;

        public PaymentRequest(String accountId, BigDecimal amount, String currency, String recipientAccount) {
            this.accountId = accountId;
            this.amount = amount;
            this.currency = currency;
            this.recipientAccount = recipientAccount;
        }

        public String accountId() { return accountId; }
        public BigDecimal amount() { return amount; }
        public String currency() { return currency; }
        public String recipientAccount() { return recipientAccount; }
    }
}