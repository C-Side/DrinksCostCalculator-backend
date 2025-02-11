package com.waldheim.calculator.impl.db;

import com.waldheim.calculator.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;

import java.math.BigDecimal;
import java.util.List;

public interface DatabaseService {

    List<PersonDTO> getAllPersons();

    Long createPerson(PersonDTO personDTO);
    List<DrinkDTO> getAllDrinks();

    Long createDrink(DrinkDTO drinkDTO);

    void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO);

    BigDecimal getTotalCost(Long personId);
}
