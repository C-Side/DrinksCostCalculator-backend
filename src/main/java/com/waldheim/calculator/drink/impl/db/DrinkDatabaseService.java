package com.waldheim.calculator.drink.impl.db;

import com.waldheim.calculator.drink.impl.DTO.DrinkCategoryDTO;
import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface DrinkDatabaseService {

    List<DrinkDTO> getAllDrinks();

    DrinkDTO createDrink(DrinkDTO drinkDTO) throws BadRequestException;

    DrinkDTO getDrinkById(Long id);

    DrinkDTO updateDrink(DrinkDTO drinkDTO);

    void deleteDrink(DrinkDTO drinkDTO);

    List<DrinkCategoryDTO> getAllDrinkCategories();

    DrinkCategoryDTO createDrinkCategory(DrinkCategoryDTO drinkCategoryDTO) throws BadRequestException;

    DrinkCategoryDTO updateDrinkCategory(DrinkCategoryDTO drinkCategoryDTO);

    void deleteDrinkCategory(DrinkCategoryDTO drinkCategoryDTO);
}
