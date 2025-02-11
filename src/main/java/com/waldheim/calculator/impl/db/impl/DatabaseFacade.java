package com.waldheim.calculator.impl.db.impl;

import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.db.DatabaseService;
import com.waldheim.calculator.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.impl.db.entity.PersonDrinkEntity;
import com.waldheim.calculator.impl.db.entity.PersonEntity;
import com.waldheim.calculator.impl.db.repository.DrinkRepository;
import com.waldheim.calculator.impl.db.repository.PersonDrinkRepository;
import com.waldheim.calculator.impl.db.repository.PersonRepository;
import com.waldheim.calculator.impl.mapper.CalculatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DatabaseFacade implements DatabaseService {

    private final PersonRepository personRepository;
    private final DrinkRepository drinkRepository;
    private final PersonDrinkRepository personDrinkRepository;
    private final CalculatorMapper calculatorMapper;

    @Autowired
    public DatabaseFacade(PersonRepository personRepository, DrinkRepository drinkRepository, PersonDrinkRepository personDrinkRepository, CalculatorMapper calculatorMapper) {
        this.personRepository = personRepository;
        this.drinkRepository = drinkRepository;
        this.personDrinkRepository = personDrinkRepository;
        this.calculatorMapper = calculatorMapper;
    }

    @Override
    public Long createPerson(PersonDTO personDTO) {
        PersonEntity newPerson = personRepository.save(calculatorMapper.personDtoToPersonEntity(personDTO));
        return newPerson.getId();
    }

    @Override
    public void addConsumedDrinkByPerson(Long personId, DrinkDTO drinkDTO) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        DrinkEntity drinkEntity = calculatorMapper.drinkDtoToDrinkEntity(drinkDTO);
        PersonDrinkEntity personDrinkEntity = personDrinkRepository.findByPersonAndDrink(personEntity, drinkEntity);
        if (personDrinkEntity == null) {
            personDrinkEntity = new PersonDrinkEntity();
            personDrinkEntity.setId(personId);
            personDrinkEntity.setDrink(drinkEntity);
            personDrinkEntity.setQuantity(0);
        }
        personDrinkEntity.setQuantity(personDrinkEntity.getQuantity() + 1);
        personDrinkRepository.save(personDrinkEntity);
    }

    @Override
    public double getTotalCost(Long personId) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        List<Object> totalCostByPerson = personDrinkRepository.findTotalCostByPerson(personEntity.getId());
        return 0;
    }
}
