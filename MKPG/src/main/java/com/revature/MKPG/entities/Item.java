package com.revature.MKPG.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity(name = "item")
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    @Column(name = "item_name")
    @Size(min=1, max=250)
    @NotBlank(message = "Item must have a name.")
    private String itemName;

    @Column
    @Size(min=1, max=10000)
    @NotBlank(message = "Description cannot be blank.")
    private String description;

    @Column
    @Positive
    @DecimalMin(value= "0.01")
    private Double price;

    @Column
    @Positive
    @DecimalMin(value= "0.01")
    private Double discountedPrice;

    @Column
    @Size(min=1, max=16)
    @NotBlank(message = "If item is not yet rated put \"Pending Rating\" otherwise item must have a rating.")
    private String rating;

    @OneToMany(mappedBy = "item")
    @JsonBackReference
    private List<Order> orders;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    public Item(){}

    public Item(String itemName, String description, Double price, Double discountedPrice, String rating) {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
                ", order=" + orders +
                ", category=" + category +
                '}';
    }
}
