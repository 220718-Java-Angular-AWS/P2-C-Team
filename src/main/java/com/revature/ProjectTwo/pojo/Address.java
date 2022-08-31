package com.revature.pojo;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer addressId;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String type;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Address() {
    }

    public Address(Integer addressId, String street, String city, String state, String type, Customer customer) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.type = type;
        this.customer = customer;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", customer=" + customer +
                '}';
    }
}