package com.waldheim.calculator.impl.facade;

import com.waldheim.calculator.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.db.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DrinkCostCalculatorFacade {

    private final DatabaseService databaseService;

    @Autowired
    public DrinkCostCalculatorFacade(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<PersonDTO> getAllPersons() {
        return databaseService.getAllPersons();
    }

    public Long createPerson(PersonDTO personDTO) {
        return databaseService.createPerson(personDTO);
    }

    public List<DrinkDTO> getAllDrinks() {
        return databaseService.getAllDrinks();
    }

    public Long createDrink(DrinkDTO drinkDTO) {
        return databaseService.createDrink(drinkDTO);
    }

    public void addConsumedDrinkByPerson(Long personId, DrinkAddedDTO drinkAddedDTO) {
        databaseService.addConsumedDrinkByPerson(personId, drinkAddedDTO);
    }

    public BigDecimal calculateTotalCostByPerson(Long personId) {
        return databaseService.getTotalCost(personId);
    }
}
