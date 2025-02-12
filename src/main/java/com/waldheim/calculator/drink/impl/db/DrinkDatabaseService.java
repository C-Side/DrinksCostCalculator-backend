package com.waldheim.calculator.drink.impl.db;

import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface DrinkDatabaseService {

    List<DrinkDTO> getAllDrinks();

    DrinkDTO createDrink(DrinkDTO drinkDTO) throws BadRequestException;

    DrinkDTO getDrinkById(Long id);

    DrinkDTO updateDrink(DrinkDTO drinkDto);

    void deleteDrink(DrinkDTO drinkDTO);
}
