package com.waldheim.calculator.impl.DTO;

import java.util.List;

public record PersonDTO(Long id, String name, List<DrinkDTO> drinks) {
}
