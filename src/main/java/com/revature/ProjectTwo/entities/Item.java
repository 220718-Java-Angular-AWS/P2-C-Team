package com.revature.ProjectTwo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "items")
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
    private Double discountPrice;

    @Column
    private Date releasedDate;
    @Column
    private Integer quantity;

    @Column
    private Integer ageRestriction;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Category category;

    public Item() {
    }

    public Item(String itemName, String description, Double price, Double discountPrice, Date releasedDate, Integer quantity, Integer ageRestriction, Category category) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.releasedDate = releasedDate;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
        this.category = category;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) && Objects.equals(itemName, item.itemName) && Objects.equals(description, item.description) && Objects.equals(price, item.price) && Objects.equals(discountPrice, item.discountPrice) && Objects.equals(releasedDate, item.releasedDate) && Objects.equals(quantity, item.quantity) && Objects.equals(ageRestriction, item.ageRestriction) && Objects.equals(category, item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, description, price, discountPrice, releasedDate, quantity, ageRestriction, category);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", releasedDate=" + releasedDate +
                ", quantity=" + quantity +
                ", ageRestriction=" + ageRestriction +
                ", category=" + category +
                '}';
    }
}
