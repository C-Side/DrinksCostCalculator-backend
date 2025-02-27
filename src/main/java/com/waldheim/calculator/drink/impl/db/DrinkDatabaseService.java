package com.waldheim.calculator.drink.impl.db;

import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import com.waldheim.calculator.drink.impl.DTO.DrinkKindDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface DrinkDatabaseService {

    List<DrinkDTO> getAllDrinks();

    DrinkDTO createDrink(DrinkDTO drinkDTO) throws BadRequestException;

    DrinkDTO getDrinkById(Long id);

    DrinkDTO updateDrink(DrinkDTO drinkDTO);

    void deleteDrink(DrinkDTO drinkDTO);

    List<DrinkKindDTO> getAllDrinkKinds();

    DrinkKindDTO createDrinkKind(DrinkKindDTO drinkKindDTO) throws BadRequestException;

    DrinkKindDTO updateDrinkKind(DrinkKindDTO drinkKindDTO);

    void deleteDrinkKind(DrinkKindDTO drinkKindDTO);
}
