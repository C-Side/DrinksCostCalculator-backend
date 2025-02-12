package com.waldheim.calculator.impl.facade;

import com.waldheim.calculator.api.DrinkCostCalculatorService;
import com.waldheim.calculator.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.db.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class DrinkCostCalculatorFacade implements DrinkCostCalculatorService {

    private final DatabaseService databaseService;

    @Autowired
    public DrinkCostCalculatorFacade(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return databaseService.getAllPersons();
    }

    @Override
    public Long createPerson(PersonDTO personDTO) {
        return databaseService.createPerson(personDTO);
    }

    @Override
    public List<DrinkDTO> getAllDrinks() {
        return databaseService.getAllDrinks();
    }

    @Override
    public Long createDrink(DrinkDTO drinkDTO) {
        return databaseService.createDrink(drinkDTO);
    }

    @Override
    public void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO) {
        databaseService.addConsumedDrinkByPerson(personId, drinkAddedDTO);
    }

    @Override
    public BigDecimal calculateTotalCostByPerson(Long personId) {
        return databaseService.getTotalCost(personId).setScale(2, RoundingMode.CEILING);
    }
}
