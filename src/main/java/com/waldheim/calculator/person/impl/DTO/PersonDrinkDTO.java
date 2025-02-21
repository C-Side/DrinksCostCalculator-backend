package com.waldheim.calculator.person.impl.DTO;

import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;

public record PersonDrinkDTO(
        Long id,
        PersonDTO person,
        DrinkDTO drink,
        Integer quantity
) {
}
