package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate orderPlacementDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "ordered_items",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;


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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", orderPlacementDate=" + orderPlacementDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getId() == payment.getId() && getOrderPlacementDate().equals(payment.getOrderPlacementDate()) && getCustomer().equals(payment.getCustomer()) && getItems().equals(payment.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderPlacementDate(), getCustomer(), getItems());
    }
}