package com.pragma.payments.infrastructure.adapter;

import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.infrastructure.adapter.entity.PaymentEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentEntityMapper {

    public Payment toDomain(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Payment payment = new Payment(
                entity.getId(),
                entity.getAccountId(),
                entity.getAmount(),
                entity.getCurrency(),
                entity.getRecipientAccount()
        );
        
        payment.setStatus(PaymentStatus.valueOf(entity.getStatus()));
        payment.setFailureReason(entity.getFailureReason());
        
        return payment;
    }

    public PaymentEntity toEntity(Payment payment) {
        if (payment == null) {
            return null;
        }
        
        PaymentEntity entity = new PaymentEntity();
        entity.setId(payment.getId());
        entity.setAccountId(payment.getAccountId());
        entity.setAmount(payment.getAmount());
        entity.setCurrency(payment.getCurrency());
        entity.setRecipientAccount(payment.getRecipientAccount());
        entity.setCreatedAt(payment.getCreatedAt() != null ? payment.getCreatedAt() : LocalDateTime.now());
        entity.setStatus(payment.getStatus() != null ? payment.getStatus().name() : PaymentStatus.PENDING.name());
        entity.setFailureReason(payment.getFailureReason());
        
        return entity;
    }
}