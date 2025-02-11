package com.waldheim.calculator.impl.DTO;

import com.waldheim.calculator.impl.db.entity.PersonDrinkEntity;

import java.util.Set;

public record DrinkDTO(Long id, String name, double price) {
}
