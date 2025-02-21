package com.waldheim.calculator.drink.api;

import com.waldheim.calculator.drink.impl.DTO.DrinkKindDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface DrinkKindService {
    List<DrinkKindDTO> getAllDrinkKinds();

    DrinkKindDTO createDrinkKind(DrinkKindDTO drinkKindDTO) throws BadRequestException;

    DrinkKindDTO updateDrinkKind(DrinkKindDTO drinkKindDTO);

    void deleteDrinkKind(DrinkKindDTO drinkKindDTO);
}

