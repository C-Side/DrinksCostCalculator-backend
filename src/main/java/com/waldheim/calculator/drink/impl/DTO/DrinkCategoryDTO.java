package com.waldheim.calculator.drink.impl.DTO;

import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;

import java.util.List;

public record DrinkCategoryDTO(
        Long id,
        String category,
        boolean alcoholic,
        List<DrinkEntity> allDrinksOfCategory) {
}
