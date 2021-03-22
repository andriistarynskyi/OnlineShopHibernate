package com.example.demo.repository;

import com.example.demo.entity.Payment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PaymentRepository implements IPaymentRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Payment payment) {
        em.persist(payment);
    }

    @Override
    public List<Payment> findAll() {
        String txt = "SELECT p FROM Payment p";
        TypedQuery<Payment> query = em.createQuery(txt, Payment.class);
        return query.getResultList();
    }
}
