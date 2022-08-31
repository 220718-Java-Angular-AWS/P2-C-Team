package com.revature.MKPG.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "item")
public class Item {
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
    private String rating;

    @ManyToOne ( cascade = CascadeType.ALL)
    @JsonBackReference
    private Cart cart;

    @ManyToOne (cascade = CascadeType.ALL)
    @JsonBackReference
    private Orders orders;

    public Item(){}

    public Item(String itemName, String description, Double price, Double discountedPrice, String rating){
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.rating = rating;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public String getRating() {
        return rating;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId.equals(item.itemId) && itemName.equals(item.itemName) && description.equals(item.description) && price.equals(item.price) && Objects.equals(discountedPrice, item.discountedPrice) && rating.equals(item.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, description, price, discountedPrice, rating);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountedPrice=" + discountedPrice +
                ", rating='" + rating + '\'' +
                '}';
    }
}
