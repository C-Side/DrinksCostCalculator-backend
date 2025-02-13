package com.waldheim.calculator.person.impl.facade;

import com.waldheim.calculator.person.api.PersonService;
import com.waldheim.calculator.person.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import com.waldheim.calculator.person.impl.db.PersonDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class PersonFacade implements PersonService {

    private final PersonDatabaseService personDatabaseService;

    @Autowired
    public PersonFacade(PersonDatabaseService personDatabaseService) {
        this.personDatabaseService = personDatabaseService;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return personDatabaseService.getAllPersons();
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        return personDatabaseService.createPerson(personDTO);
    }

    @Override
    public void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO) {
        personDatabaseService.addConsumedDrinkByPerson(personId, drinkAddedDTO);
    }

    @Override
    public BigDecimal calculateTotalCostByPerson(Long personId) {
        BigDecimal totalCost = personDatabaseService.getTotalCost(personId);
        return totalCost == null ? BigDecimal.ZERO : totalCost.setScale(2, RoundingMode.CEILING);
    }
}
