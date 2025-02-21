package com.waldheim.calculator.person.impl.DTO;

import java.util.List;

public record PersonDTO(
        Long id,
        String name,
        int age,
        String role,
        List<PersonDrinkDTO> drinksConsumedByPerson) {
}
