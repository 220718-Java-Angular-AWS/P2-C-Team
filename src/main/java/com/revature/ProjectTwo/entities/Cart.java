package com.revature.ProjectTwo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "item_id")
    private Item item;

    @Column
    private int quantity;

    @Column
    @Temporal(TemporalType.DATE)
    private Date checkOutDate;

    public Cart() {
    }

}
