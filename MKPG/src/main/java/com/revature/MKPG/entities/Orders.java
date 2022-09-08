package com.revature.MKPG.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer cartId;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JsonBackReference
    private List<Item> items;

    @Column
    private int quantity;

    @Column
    private String deliveryDate;
    @Column
    private String status;

    public Orders() {
    }

    public Orders(Integer cartId, Customer customer, List<Item> items, int quantity, String deliveryDate, String status) {
        this.cartId = cartId;
        this.customer = customer;
        this.items = items;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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
        Orders orders = (Orders) o;
        return quantity == orders.quantity && Objects.equals(cartId, orders.cartId) && Objects.equals(customer, orders.customer) && Objects.equals(items, orders.items) && Objects.equals(deliveryDate, orders.deliveryDate) && Objects.equals(status, orders.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, customer, items, quantity, deliveryDate, status);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "cartId=" + cartId +
                ", customer=" + customer +
                ", items=" + items +
                ", quantity=" + quantity +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}