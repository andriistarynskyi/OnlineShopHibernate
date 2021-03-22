package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.Payment;
import com.example.demo.repository.IPaymentRepository;
import com.example.demo.utils.Constant;
import com.example.demo.utils.DateParser;
import com.example.demo.utils.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IItemService itemService;
    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public List<Payment> parse() {
        String customersFilePath = Constant.CUSTOMERS_FILE_PATH;
        List<String> orderDataList = FileReader.read(customersFilePath);
        List<Payment> payments = new ArrayList<>();
        for (String str : orderDataList) {
            Payment payment = new Payment();
            String[] tempArray = str.split(";");
            Customer customer = customerService.findByName(tempArray[0]);
            payment.setCustomer(customer);
            LocalDate orderPlacementDate = DateParser.parse(tempArray[6], Constant.ORDER_PLACEMENT_DATE_PATTERN);
            payment.setOrderPlacementDate(orderPlacementDate);
            List<Item> items = getPurchasedItems(tempArray[5]);
            payment.setItems(items);

            payments.add(payment);
        }
        return payments;
    }

    @Override
    public List<Integer> getItemCodes(String str) {
        List<Integer> listOfProductIds = new ArrayList<>();
        String strWithoutQuotes = str.substring(1, str.length() - 1);
        if (strWithoutQuotes.length() > 2) {
            String[] tempArray = strWithoutQuotes.split(" ");
            for (String s : tempArray) {
                int code = 0;
                code = Integer.valueOf(s);
                listOfProductIds.add(code);
            }
        } else {
            listOfProductIds.add(Integer.valueOf(strWithoutQuotes));
        }
        return listOfProductIds;
    }

    @Override
    public List<Item> parseItems(List<Integer> itemCodes) {
        List<Item> items = new ArrayList<>();
        for (Integer i : itemCodes) {
            Item item = itemService.findById(i);
            items.add(item);
        }
        return items;
    }

    @Override
    public List<Item> getPurchasedItems(String str) {
        return parseItems(getItemCodes(str));
    }

    @Override
    @Transactional
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
}