package com.waldheim.calculator.drink.impl.facade;

import com.waldheim.calculator.drink.api.DrinkCategoriesService;
import com.waldheim.calculator.drink.impl.DTO.DrinkCategoryDTO;
import com.waldheim.calculator.drink.impl.db.DrinkDatabaseService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkCategoriesFacade implements DrinkCategoriesService {

    private final DrinkDatabaseService drinkDatabaseService;

    @Autowired
    public DrinkCategoriesFacade(DrinkDatabaseService drinkDatabaseService) {
        this.drinkDatabaseService = drinkDatabaseService;
    }

    @Override
    public List<DrinkCategoryDTO> getAllDrinkCategories() {
        return drinkDatabaseService.getAllDrinkCategories();
    }

    @Override
    public DrinkCategoryDTO createDrinkCategory(DrinkCategoryDTO drinkCategoryDTO) throws BadRequestException {
        return drinkDatabaseService.createDrinkCategory(drinkCategoryDTO);
    }

    @Override
    public DrinkCategoryDTO updateDrinkCategory(DrinkCategoryDTO drinkCategoryDTO) {
        return drinkDatabaseService.updateDrinkCategory(drinkCategoryDTO);
    }

    @Override
    public void deleteDrinkCategory(DrinkCategoryDTO drinkCategoryDTO) {
        drinkDatabaseService.deleteDrinkCategory(drinkCategoryDTO);
    }
}
