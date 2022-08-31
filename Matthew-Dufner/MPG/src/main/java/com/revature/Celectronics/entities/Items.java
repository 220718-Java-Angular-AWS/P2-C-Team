package com.revature.Celectronics.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name = "items")
public class Items {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column
    private String itemName;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private Double discountedPrice;

    @Column
    private String Rating;

    @ManyToOne ( cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Cart> cart;

    @ManyToOne (cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Orders> orders;
}
