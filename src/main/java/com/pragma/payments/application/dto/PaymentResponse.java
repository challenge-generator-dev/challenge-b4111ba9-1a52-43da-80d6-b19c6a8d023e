package com.pragma.payments.application.dto;


import com.pragma.payments.domain.model.PaymentStatus;
import com.pragma.payments.domain.model.Payment;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentResponse(
    UUID id,
    String accountId,
    BigDecimal amount,
    String currency,
    String recipientAccount,
    LocalDateTime createdAt,
    String status,
    String failureReason
) {
    public static PaymentResponse fromDomain(Payment payment) {
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

    public static PaymentResponse pending(UUID id, String accountId, BigDecimal amount, 
            String currency, String recipientAccount) {
        return new PaymentResponse(
            id,
            accountId,
            amount,
            currency,
            recipientAccount,
            LocalDateTime.now(),
            Payment.PaymentStatus.PENDING.name(),
            null
        );
    }

    public boolean isSuccessful() {
        return Payment.PaymentStatus.COMPLETED.name().equals(status);
    }

    public boolean isFailed() {
        return Payment.PaymentStatus.FAILED.name().equals(status);
    }

    public boolean isPending() {
        return Payment.PaymentStatus.PENDING.name().equals(status);
    }

    public PaymentResponse withStatus(String newStatus) {
        return new PaymentResponse(
            this.id,
            this.accountId,
            this.amount,
            this.currency,
            this.recipientAccount,
            this.createdAt,
            newStatus,
            this.failureReason
        );
    }

    public PaymentResponse withFailureReason(String reason) {
        return new PaymentResponse(
            this.id,
            this.accountId,
            this.amount,
            this.currency,
            this.recipientAccount,
            this.createdAt,
            this.status,
            reason
        );
    }
}