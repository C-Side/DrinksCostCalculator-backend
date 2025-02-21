package com.waldheim.calculator.drink.impl.DTO;

public record DrinkDTO(
        Long id,
        String name,
        double price,
        DrinkKindDTO drinkKind) {
}
