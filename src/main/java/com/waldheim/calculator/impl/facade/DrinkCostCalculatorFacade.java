package com.waldheim.calculator.impl.facade;

import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.impl.db.entity.PersonEntity;
import com.waldheim.calculator.impl.db.repository.DrinkRepository;
import com.waldheim.calculator.impl.db.repository.PersonRepository;
import com.waldheim.calculator.impl.mapper.CalculatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DrinkCostCalculatorFacade {

    private final PersonRepository personRepository;
    private final DrinkRepository drinkRepository;
    private final CalculatorMapper calculatorMapper;

    public DrinkCostCalculatorFacade(@Autowired PersonRepository personRepository, @Autowired DrinkRepository drinkRepository, @Autowired CalculatorMapper calculatorMapper) {
        this.personRepository = personRepository;
        this.drinkRepository = drinkRepository;
        this.calculatorMapper = calculatorMapper;
    }

    public Long createPerson(PersonDTO personDTO) {
        PersonEntity newPerson = personRepository.save(calculatorMapper.toPersonEntity(personDTO));
        return newPerson.getId();
    }

    public void addDrinkToPerson(Long personId, DrinkDTO drinkDTO) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(() -> new NoSuchElementException("Person not found"));
        personEntity.getDrinks().add(drinkRepository.getReferenceById(drinkDTO.id()));
        personRepository.save(personEntity);
    }

    public double calculateTotalCost(Long personId) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(() -> new NoSuchElementException("Person not found"));
        return personEntity.getDrinks().stream().mapToDouble(DrinkEntity::getPrice).sum();
    }
}
