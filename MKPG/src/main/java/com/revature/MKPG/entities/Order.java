package com.revature.MKPG.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Integer orderId;

    @Column
    private int quantity;

    @Column
    private String deliveryDate;

    @Column
    private String status;

    @ManyToOne
    @JsonBackReference
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "item")
    private List<Item> items;
    public Order() {
    }

    public Order(Integer cartId, Customer customer, List<Item> items, int quantity, String deliveryDate, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && Objects.equals(orderId, order.orderId) && Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(status, order.status) && Objects.equals(customer, order.customer) && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, quantity, deliveryDate, status, customer, items);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", quantity=" + quantity +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }
}