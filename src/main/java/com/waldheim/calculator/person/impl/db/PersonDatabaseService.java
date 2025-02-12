package com.waldheim.calculator.person.impl.db;

import com.waldheim.calculator.person.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PersonDatabaseService {

    List<PersonDTO> getAllPersons();

    PersonDTO createPerson(PersonDTO personDTO);

    void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO);

    BigDecimal getTotalCost(Long personId);
}
