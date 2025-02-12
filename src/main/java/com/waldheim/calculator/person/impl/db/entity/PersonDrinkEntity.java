package com.waldheim.calculator.person.impl.db.entity;

import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import jakarta.persistence.*;

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
