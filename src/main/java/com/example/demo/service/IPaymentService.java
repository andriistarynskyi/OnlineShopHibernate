package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.entity.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> parse();

    List<Integer> getItemCodes(String str);

    List<Item> parseItems(List<Integer> itemCodes);

    List<Item> getPurchasedItems(String str);

    void save(Payment payment);

    List<Payment> findAll();
}
