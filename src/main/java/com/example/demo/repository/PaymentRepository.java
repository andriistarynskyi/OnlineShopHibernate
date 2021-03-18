package com.example.demo.repository;

import com.example.demo.entity.Payment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PaymentRepository implements IPaymentRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public Payment findById(int id) {
        return em.find(Payment.class, id);
    }
}
