package com.waldheim.calculator.impl.mapper;

import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.impl.db.entity.PersonEntity;
import com.waldheim.calculator.impl.db.repository.DrinkRepository;
import com.waldheim.calculator.impl.db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorMapper {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private DrinkRepository drinkRepository;

    public PersonDTO toPersonDTO(PersonEntity personEntity) {
        return new PersonDTO(personEntity.getId(),
                personEntity.getName(),
                personEntity.getDrinks().stream().map(this::toDrinkDTO).toList());
    }

    public PersonEntity toPersonEntity(PersonDTO personDTO) {
        return new PersonEntity(personDTO.name(),
                personDTO.drinks().stream().map(this::toDrinkEntity).toList());
    }

    public DrinkDTO toDrinkDTO(DrinkEntity drinkEntity) {
        return new DrinkDTO(drinkEntity.getId(),
                drinkEntity.getName(),
                drinkEntity.getPrice());
    }

    public DrinkEntity toDrinkEntity(DrinkDTO drinkDTO) {
        return new DrinkEntity(drinkDTO.name(),
                drinkDTO.price());
    }
}
