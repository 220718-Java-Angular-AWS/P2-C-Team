package com.revature.pojo;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer itemId;
    @Column
    private String itemName;
    @Column
    private String description;

    private Double price;

    @Column
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;



    public Item() {
    }

    public Item(Integer itemId, String itemName, String description, String color, String size, Integer quantity, String unit, Product product) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.unit = unit;
        this.product = product;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", product=" + product +
                '}';
    }
}
