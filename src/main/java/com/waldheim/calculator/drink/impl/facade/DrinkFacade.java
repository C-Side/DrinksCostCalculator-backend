package com.waldheim.calculator.drink.impl.facade;

import com.waldheim.calculator.drink.api.DrinkService;
import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import com.waldheim.calculator.drink.impl.db.DrinkDatabaseService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkFacade implements DrinkService {

    private final DrinkDatabaseService drinkDatabaseService;

    @Autowired
    public DrinkFacade(DrinkDatabaseService drinkDatabaseService) {
        this.drinkDatabaseService = drinkDatabaseService;
    }

    @Override
    public List<DrinkDTO> getAllDrinks() {
        return drinkDatabaseService.getAllDrinks();
    }

    @Override
    public DrinkDTO createDrink(DrinkDTO drinkDTO) throws BadRequestException {
        return drinkDatabaseService.createDrink(drinkDTO);
    }

    @Override
    public DrinkDTO getDrinkById(Long id) {
        return drinkDatabaseService.getDrinkById(id);
    }

    @Override
    public DrinkDTO updateDrink(DrinkDTO drinkDTO) {
        return drinkDatabaseService.updateDrink(drinkDTO);
    }

    @Override
    public void deleteDrink(DrinkDTO drinkDTO) {
        drinkDatabaseService.deleteDrink(drinkDTO);
    }
}
