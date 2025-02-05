package com.waldheim.calculator.impl.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DrinkEntity> drinks;

    public PersonEntity(String name, List<DrinkEntity> drinks) {
        this.name = name;
        this.drinks = drinks;
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

    public List<DrinkEntity> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkEntity> drinkEntities) {
        this.drinks = drinkEntities;
    }
}
