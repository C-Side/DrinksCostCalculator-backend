package com.waldheim.calculator.person.impl.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String role;

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL)
    private List<PersonDrinkEntity> drinksConsumedByPerson;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<PersonDrinkEntity> getDrinksConsumedByPerson() {
        return drinksConsumedByPerson;
    }

    public void setDrinksConsumedByPerson(List<PersonDrinkEntity> personDrinks) {
        this.drinksConsumedByPerson = personDrinks;
    }
}
