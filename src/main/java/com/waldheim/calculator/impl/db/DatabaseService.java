package com.waldheim.calculator.impl.db;

import com.waldheim.calculator.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;

import java.util.List;

public interface DatabaseService {

    List<PersonDTO> getAllPersons();
    public Long createPerson(PersonDTO personDTO);
    List<DrinkDTO> getAllDrinks();
    public void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO);
    public double getTotalCost(Long personId);
}
