package com.waldheim.calculator.person.impl.db.impl;

import com.waldheim.calculator.common.mapper.CalculatorMapper;
import com.waldheim.calculator.drink.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import com.waldheim.calculator.person.impl.db.PersonDatabaseService;
import com.waldheim.calculator.person.impl.db.entity.PersonDrinkEntity;
import com.waldheim.calculator.person.impl.db.entity.PersonEntity;
import com.waldheim.calculator.person.impl.db.repository.PersonDrinkRepository;
import com.waldheim.calculator.person.impl.db.repository.PersonRepository;
import org.apache.coyote.BadRequestException;
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
        return personRepository.findAll().stream().map(calculatorMapper::personEntityToPersonDTO).collect(Collectors.toList());
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) throws BadRequestException {
        if (personDTO.id() != null) {
            throw new BadRequestException("A new person cannot already have an ID");
        }
        PersonEntity newPerson = personRepository.save(calculatorMapper.personDTOToPersonEntity(personDTO));
        return calculatorMapper.personEntityToPersonDTO(newPerson);
    }

    @Override
    public void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(NoSuchElementException::new);
        DrinkEntity drinkEntity = calculatorMapper.drinkDTOToDrinkEntity(drinkAddedDTO.drinkDTO());
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

    @Override
    public PersonDTO updatePerson(PersonDTO personDTO) {
        PersonEntity personEntity = personRepository.save(calculatorMapper.personDTOToPersonEntity(personDTO));
        return calculatorMapper.personEntityToPersonDTO(personEntity);
    }

    @Override
    public void deletePerson(PersonDTO personDTO) {
        personRepository.delete(calculatorMapper.personDTOToPersonEntity(personDTO));
    }
}
