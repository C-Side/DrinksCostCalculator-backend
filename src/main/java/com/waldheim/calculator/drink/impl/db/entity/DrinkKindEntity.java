package com.waldheim.calculator.drink.impl.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drink_kinds")
public class DrinkKindEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kind;
    private boolean isAlcoholic;

    @OneToMany(mappedBy = "drinkKind", cascade = CascadeType.ALL)
    private List<DrinkEntity> drinks;

    public DrinkKindEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public List<DrinkEntity> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkEntity> drinks) {
        this.drinks = drinks;
    }
}
