package com.revature.MKPG.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
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
    @Temporal(TemporalType.DATE)
    @Column
    private Date checkOutDate;

    public Cart() {
    }

    public Cart(Integer cartId, Customer customer, List<Item> itemList, int quantity, Date checkOutDate) {
        this.cartId = cartId;
        this.customer = customer;
        this.items = itemList;
        this.quantity = quantity;
        this.checkOutDate = checkOutDate;
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

    public List<Item> getItemList() {
        return items;
    }

    public void setItemList(List<Item> itemList) {
        this.items = itemList;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customer=" + customer +
                ", itemList=" + items +
                ", quantity=" + quantity +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}