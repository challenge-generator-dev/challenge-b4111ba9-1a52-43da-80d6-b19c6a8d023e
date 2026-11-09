package com.pragma.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private final UUID id;
    private final String accountId;
    private final BigDecimal amount;
    private final String currency;
    private final String recipientAccount;
    private final LocalDateTime createdAt;
    private PaymentStatus status;
    private String failureReason;

    public Payment(UUID id, String accountId, BigDecimal amount, String currency,
                  String recipientAccount, LocalDateTime createdAt, PaymentStatus status) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.currency = currency;
        this.recipientAccount = recipientAccount;
        this.createdAt = createdAt;
        this.status = status;
        this.failureReason = null;
    }

    public Payment(String accountId, BigDecimal amount, String currency, String recipientAccount) {
        this(UUID.randomUUID(), accountId, amount, currency, recipientAccount, LocalDateTime.now(), PaymentStatus.PENDING);
    }

    public UUID getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void markAsCompleted() {
        this.status = PaymentStatus.COMPLETED;
    }

    public void markAsFailed(String reason) {
        this.status = PaymentStatus.FAILED;
        this.failureReason = reason;
    }

    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        FAILED
    }
}