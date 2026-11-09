package com.pragma.payments.infrastructure.adapter;

import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.domain.port.PaymentRepository;
import com.pragma.payments.infrastructure.adapter.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaPaymentRepository implements PaymentRepository {

    private final PaymentJpaAdapter paymentJpaAdapter;

    public JpaPaymentRepository(PaymentJpaAdapter paymentJpaAdapter) {
        this.paymentJpaAdapter = paymentJpaAdapter;
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = toEntity(payment);
        PaymentEntity savedEntity = paymentJpaAdapter.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return paymentJpaAdapter.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Payment> findByAccountId(String accountId) {
        return paymentJpaAdapter.findByAccountId(accountId)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Payment> findByStatus(PaymentStatus status) {
        return paymentJpaAdapter.findByStatus(status.name())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private PaymentEntity toEntity(Payment payment) {
        PaymentEntity entity = new PaymentEntity();
        entity.setId(payment.getId());
        entity.setAccountId(payment.getAccountId());
        entity.setAmount(payment.getAmount());
        entity.setCurrency(payment.getCurrency());
        entity.setRecipientAccount(payment.getRecipientAccount());
        entity.setCreatedAt(payment.getCreatedAt());
        entity.setStatus(payment.getStatus().name());
        entity.setFailureReason(payment.getFailureReason());
        return entity;
    }

    private Payment toDomain(PaymentEntity entity) {
        Payment payment = new Payment(
            entity.getId(),
            entity.getAccountId(),
            entity.getAmount(),
            entity.getCurrency(),
            entity.getRecipientAccount(),
            entity.getCreatedAt(),
            PaymentStatus.valueOf(entity.getStatus())
        );
        if (entity.getFailureReason() != null) {
            payment.markAsFailed(entity.getFailureReason());
        }
        return payment;
    }
}