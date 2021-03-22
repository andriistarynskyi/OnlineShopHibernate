package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Item;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.utils.Constant;
import com.example.demo.utils.DateParser;
import com.example.demo.utils.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    @Transactional
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
     public List<Customer> parseCustomersFromFile() {
        String customersFilePath = Constant.CUSTOMERS_FILE_PATH;
        List<String> customersDataList = FileReader.read(customersFilePath);
        List<Customer> customers = new ArrayList<>();

        for (String str : customersDataList) {
            String[] tempArray = str.split(";");
            Customer customer = new Customer();
            customer.setName(tempArray[0]);
            customer.setDateOfBirth(DateParser.parse(tempArray[1], Constant.DOB_PATTERN));
            customer.setAddress(tempArray[2]);
            customer.setGender(getGender(tempArray[3]));
            customer.setPhoneNumber(tempArray[4]);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Gender getGender(String str) {
        Gender gender = null;
        if (str.equals("Male") || (str.equals("male"))) {
            gender = Gender.MALE;
        } else if (str.equals("Female") || (str.equals("female"))) {
            gender = Gender.FEMALE;
        }
        return gender;
    }

    @Override
    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }
}