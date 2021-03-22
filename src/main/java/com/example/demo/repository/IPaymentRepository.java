package com.example.demo.repository;

import com.example.demo.entity.Payment;

import java.util.List;

public interface IPaymentRepository {
    void save(Payment payment);

    List<Payment> findAll();
}
