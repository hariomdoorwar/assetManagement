package com.assetManagement.assetManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    @Column(name = "name")
    private String name;

    @Column(name = "categoryId")
    private long categoryId;

    @Column(name ="cost")
    private long cost;

    @Column(name = "DoP")
    private String DoP;

    public Item() {
    }

    public Item(long categoryId, long itemId, String name, String DoP, long cost) {
        this.categoryId = categoryId;
        this.itemId = itemId;
        this.name = name;
        this.DoP = DoP;
        this.cost = cost;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getDoP() {
        return DoP;
    }

    public void setDoP(String doP) {
        DoP = doP;
    }
}
