package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate orderPlacementDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "ordered_items",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Collection<Item> items = new ArrayList<>();


    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderPlacementDate() {
        return orderPlacementDate;
    }

    public void setOrderPlacementDate(LocalDate orderPlacementDate) {
        this.orderPlacementDate = orderPlacementDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", orderPlacementDate=" + orderPlacementDate +
                ", customer=" + customer +
                '}';
    }

//    public Collection<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(Collection<Item> items) {
//        this.items = items;
//    }
}