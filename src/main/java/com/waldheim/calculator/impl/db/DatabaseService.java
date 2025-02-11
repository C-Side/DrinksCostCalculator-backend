package com.waldheim.calculator.impl.db;

import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;

public interface DatabaseService {

    public Long createPerson(PersonDTO personDTO);
    public void addConsumedDrinkByPerson(Long personId, DrinkDTO drinkDTO);
    public double getTotalCost(Long personId);

}
