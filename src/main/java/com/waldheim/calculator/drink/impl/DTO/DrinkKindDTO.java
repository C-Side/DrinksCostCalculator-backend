package com.waldheim.calculator.drink.impl.DTO;

import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;

import java.util.List;

public record DrinkKindDTO(
        Long id,
        String kind,
        boolean isAlcoholic,
        List<DrinkEntity> allDrinksOfKind) {
}
