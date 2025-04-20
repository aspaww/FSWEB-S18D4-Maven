package com.workintech.s18d1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "burger", schema = "public")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    private String contents;

    public Burger() { }

    public Burger(Long id, String name, double price, boolean isVegan, BreadType breadType, String contents) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isVegan = isVegan;
        this.breadType = breadType;
        this.contents = contents;
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // alias olarak testin kullandığı getIsVegan metodu:
    public boolean getIsVegan() {
        return isVegan;
    }

    // orijinal isVegan getter
    public boolean isVegan() {
        return isVegan;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public String getContents() {
        return contents;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isVegan=" + isVegan +
                ", breadType=" + breadType +
                ", contents='" + contents + '\'' +
                '}';
    }
}
