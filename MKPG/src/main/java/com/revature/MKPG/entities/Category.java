package com.revature.MKPG.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column
    private String name;

    @Column
    private String console;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JoinColumn(name = "item")
    private List<Item> item;

    public Category() {
    }

    public Category(String name, String console, List<Item> item) {
        this.name = name;
        this.console = console;
        this.item = item;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public List<Item> getProducts() {
        return item;
    }

    public void setItems(List<Item> products) {
        this.item = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) && Objects.equals(name, category.name) && Objects.equals(console, category.console) && Objects.equals(item, category.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, console, item);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", console='" + console + '\'' +
                '}';
    }
}