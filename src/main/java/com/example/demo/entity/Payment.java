package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int id;
    private LocalDate orderPlacementDate;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "ordered_items",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Collection<Item> items;


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

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", orderPlacementDate=" + orderPlacementDate +
                ", customer=" + customer +
                ", items=" + items +
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