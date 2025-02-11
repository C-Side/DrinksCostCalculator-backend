package com.waldheim.calculator.impl.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import jakarta.persistence.Id;

@Entity
@Table(name = "person_drinks")
public class PersonDrinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;
    @ManyToOne
    @JoinColumn(name = "drink_id", nullable = false)
    private DrinkEntity drink;
    @Column(nullable = false)
    private Integer quantity;

    public PersonDrinkEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public DrinkEntity getDrink() {
        return drink;
    }

    public void setDrink(DrinkEntity drink) {
        this.drink = drink;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
