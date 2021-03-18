package com.example.demo.repository;

import com.example.demo.entity.Payment;

public interface IPaymentRepository {
    Payment findById(int id);
}
