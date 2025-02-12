package com.waldheim.calculator.person.impl.db.impl;

import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.mapper.CalculatorMapper;
import com.waldheim.calculator.person.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import com.waldheim.calculator.person.impl.db.PersonDatabaseService;
import com.waldheim.calculator.person.impl.db.entity.PersonDrinkEntity;
import com.waldheim.calculator.person.impl.db.entity.PersonEntity;
import com.waldheim.calculator.person.impl.db.repository.PersonDrinkRepository;
import com.waldheim.calculator.person.impl.db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonDatabaseFacade implements PersonDatabaseService {

    private final PersonRepository personRepository;
    private final PersonDrinkRepository personDrinkRepository;
    private final CalculatorMapper calculatorMapper;

    @Autowired
    public PersonDatabaseFacade(PersonRepository personRepository, PersonDrinkRepository personDrinkRepository, CalculatorMapper calculatorMapper) {
        this.personRepository = personRepository;
        this.personDrinkRepository = personDrinkRepository;
        this.calculatorMapper = calculatorMapper;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream().map(calculatorMapper::personEntityToPersonDto).collect(Collectors.toList());
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        PersonEntity newPerson = personRepository.save(calculatorMapper.personDtoToPersonEntity(personDTO));
        return calculatorMapper.personEntityToPersonDto(newPerson);
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
