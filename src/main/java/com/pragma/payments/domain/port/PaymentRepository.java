package com.pragma.payments.domain.port;


import com.pragma.payments.domain.model.PaymentStatus;
import com.pragma.payments.domain.model.Payment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
    Payment save(Payment payment);
    
    Optional<Payment> findById(UUID id);
    
    List<Payment> findByAccountId(String accountId);
    
    List<Payment> findByStatus(Payment.PaymentStatus status);
}