package com.waldheim.calculator.impl.facade;

import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.db.DatabaseService;
import com.waldheim.calculator.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.impl.db.entity.PersonEntity;
import com.waldheim.calculator.impl.mapper.CalculatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DrinkCostCalculatorFacade {

    private final DatabaseService databaseService;
    private final CalculatorMapper calculatorMapper;

    @Autowired
    public DrinkCostCalculatorFacade(DatabaseService databaseService, CalculatorMapper calculatorMapper) {
        this.databaseService = databaseService;
        this.calculatorMapper = calculatorMapper;
    }

    public Long createPerson(PersonDTO personDTO) {
        return databaseService.createPerson(personDTO);
    }

    public void addConsumedDrinkByPerson(Long personId, DrinkDTO drinkDTO) {
        databaseService.addConsumedDrinkByPerson(personId, drinkDTO);
    }

    public double calculateTotalCostByPerson(Long personId) {
        return databaseService.getTotalCost(personId);
    }
}
