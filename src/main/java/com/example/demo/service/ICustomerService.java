package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Gender;

public interface ICustomerService {
    void save(Customer customer);

    boolean parseCustomersFromFile();

    Gender getGender(String str);

}
