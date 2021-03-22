package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Gender;

import java.util.List;

public interface ICustomerService {
    void save(Customer customer);

    List<Customer> parseCustomersFromFile();

    Gender getGender(String str);

    Customer findByName(String name);
}
