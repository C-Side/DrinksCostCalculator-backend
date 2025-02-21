package com.waldheim.calculator.drink.api;

import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface DrinkService {
    List<DrinkDTO> getAllDrinks();

    DrinkDTO createDrink(DrinkDTO drinkDTO) throws BadRequestException;

    DrinkDTO getDrinkById(Long id);

    DrinkDTO updateDrink(DrinkDTO drinkDTO);

    void deleteDrink(DrinkDTO drinkDTO);
}
