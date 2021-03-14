package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository {
    void save(Customer customer);
}
