package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataFromFileSaverService implements IDataFromFileSaverService {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IItemService itemService;
    @Autowired
    private IPaymentService paymentService;

    @Override
    @Transactional
    public void save() {
        List<Customer> customers = customerService.parseCustomersFromFile();
        customers.forEach(c -> customerService.save(c));
        System.out.println("Customers from file were saved to DB");

        List<Item> items = itemService.parseItemsFromFile();
        items.forEach(i -> itemService.save(i));
        System.out.println("Items from file were saved to DB");

        List<Payment> payments = paymentService.parse();
        payments.forEach(p -> paymentService.save(p));
        System.out.println("Payments from file were saved to DB");
    }
}
