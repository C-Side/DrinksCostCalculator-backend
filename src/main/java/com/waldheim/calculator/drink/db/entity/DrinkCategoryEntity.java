package com.waldheim.calculator.drink.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drink_categories")
public class DrinkCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private boolean alcoholic;

    @OneToMany(mappedBy = "drinkCategory")
    private List<DrinkEntity> allDrinksOfCategory;

    public DrinkCategoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(boolean isAlcoholic) {
        this.alcoholic = isAlcoholic;
    }

    public List<DrinkEntity> getAllDrinksOfCategory() {
        return allDrinksOfCategory;
    }

    public void setAllDrinksOfCategory(List<DrinkEntity> drinks) {
        this.allDrinksOfCategory = drinks;
    }
}
