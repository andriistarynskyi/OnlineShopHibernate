package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Customer customer) {
        em.persist(customer);
    }
}
