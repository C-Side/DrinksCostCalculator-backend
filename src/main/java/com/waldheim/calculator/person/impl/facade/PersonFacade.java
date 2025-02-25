package com.waldheim.calculator.person.impl.facade;

import com.waldheim.calculator.person.api.PersonService;
import com.waldheim.calculator.person.db.PersonDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PersonFacade implements PersonService {

    private final PersonDatabaseService personDatabaseService;

    @Autowired
    public PersonFacade(PersonDatabaseService personDatabaseService) {
        this.personDatabaseService = personDatabaseService;
    }

    @Override
    public BigDecimal calculateTotalCostByPerson(Long personId) {
        BigDecimal totalCost = personDatabaseService.getTotalCost(personId);
        return totalCost == null ? BigDecimal.ZERO : totalCost.setScale(2, RoundingMode.CEILING);
    }
}
