package com.waldheim.calculator.drink.api;

import com.waldheim.calculator.drink.impl.DTO.DrinkCategoryDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface DrinkCategoriesService {
    List<DrinkCategoryDTO> getAllDrinkCategories();

    DrinkCategoryDTO createDrinkCategory(DrinkCategoryDTO drinkCategoryDTO) throws BadRequestException;

    DrinkCategoryDTO updateDrinkCategory(DrinkCategoryDTO drinkCategoryDTO);

    void deleteDrinkCategory(DrinkCategoryDTO drinkCategoryDTO);
}

