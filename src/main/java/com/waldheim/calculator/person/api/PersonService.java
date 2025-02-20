package com.waldheim.calculator.person.api;

import com.waldheim.calculator.person.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import org.apache.coyote.BadRequestException;

import java.math.BigDecimal;
import java.util.List;

public interface PersonService {
    List<PersonDTO> getAllPersons();

    PersonDTO createPerson(PersonDTO personDTO) throws BadRequestException;

    void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO);

    BigDecimal calculateTotalCostByPerson(Long personId);

    PersonDTO updatePerson(PersonDTO personDTO);

    void deletePerson(PersonDTO personDTO);
}
