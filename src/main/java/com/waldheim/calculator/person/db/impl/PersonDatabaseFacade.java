package com.waldheim.calculator.person.db.impl;

import com.waldheim.calculator.person.db.PersonDatabaseService;
import com.waldheim.calculator.person.db.entity.PersonEntity;
import com.waldheim.calculator.person.db.repository.PersonDrinkRepository;
import com.waldheim.calculator.person.db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PersonDatabaseFacade implements PersonDatabaseService {

    private final PersonRepository personRepository;
    private final PersonDrinkRepository personDrinkRepository;

    @Autowired
    public PersonDatabaseFacade(PersonRepository personRepository, PersonDrinkRepository personDrinkRepository) {
        this.personRepository = personRepository;
        this.personDrinkRepository = personDrinkRepository;
    }

    @Override
    public BigDecimal getTotalCost(Long personId) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        return personDrinkRepository.findTotalCostByPerson(personEntity.getId());
    }
}
