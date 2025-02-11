package com.waldheim.calculator.impl.db.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<PersonDrinkEntity> personDrinks = new HashSet<>();

    public PersonEntity() {
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

    public Set<PersonDrinkEntity> getPersonDrinks() {
        return personDrinks;
    }

    public void setPersonDrinks(Set<PersonDrinkEntity> personDrinks) {
        this.personDrinks = personDrinks;
    }
}
