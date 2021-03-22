package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Customer customer) {
        em.persist(customer);
    }
    
    @Override
    public Customer findByName(String customerName) {
        String txt = "SELECT c FROM Customer c WHERE c.name = ?1";
        TypedQuery<Customer> query = em.createQuery(txt, Customer.class).setParameter(1, customerName);
        return query.getSingleResult();
    }
}