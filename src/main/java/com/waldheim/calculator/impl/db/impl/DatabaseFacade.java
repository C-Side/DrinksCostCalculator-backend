package com.waldheim.calculator.impl.db.impl;

import com.waldheim.calculator.impl.DTO.DrinkAddedDTO;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream().map(calculatorMapper::personEntityToPersonDto).collect(Collectors.toList());
    }

    @Override
    public Long createPerson(PersonDTO personDTO) {
        PersonEntity newPerson = personRepository.save(calculatorMapper.personDtoToPersonEntity(personDTO));
        return newPerson.getId();
    }

    @Override
    public List<DrinkDTO> getAllDrinks() {
        return drinkRepository.findAll().stream().map(calculatorMapper::drinkEntityDtoToDrinkDto).collect(Collectors.toList());
    }

    @Override
    public Long createDrink(DrinkDTO drinkDTO) {
        DrinkEntity drinkEntity = drinkRepository.save(calculatorMapper.drinkDtoToDrinkEntity(drinkDTO));
        return drinkEntity.getId();
    }

    @Override
    public void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        DrinkEntity drinkEntity = calculatorMapper.drinkDtoToDrinkEntity(drinkAddedDTO.drinkDTO());
        PersonDrinkEntity personDrinkEntity = personDrinkRepository.findByPersonAndDrink(personEntity, drinkEntity);
        if (personDrinkEntity == null) {
            personDrinkEntity = new PersonDrinkEntity();
            personDrinkEntity.setPerson(personEntity);
            personDrinkEntity.setDrink(drinkEntity);
            personDrinkEntity.setQuantity(0);
        }
        personDrinkEntity.setQuantity(personDrinkEntity.getQuantity() + drinkAddedDTO.quantity());
        personDrinkRepository.save(personDrinkEntity);
    }

    @Override
    public BigDecimal getTotalCost(Long personId) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        return personDrinkRepository.findTotalCostByPerson(personEntity.getId());
    }
}
