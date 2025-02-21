package com.waldheim.calculator.drink.impl.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "drinks")
public class DrinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "drink_kinds_id", nullable = false)
    private DrinkKindEntity drinkKind;

    public DrinkEntity() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DrinkKindEntity getDrinkKind() {
        return drinkKind;
    }

    public void setDrinkKind(DrinkKindEntity drinkKind) {
        this.drinkKind = drinkKind;
    }
}
