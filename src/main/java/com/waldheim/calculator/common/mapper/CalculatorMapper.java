package com.waldheim.calculator.common.mapper;

import com.waldheim.calculator.drink.impl.DTO.DrinkCategoryDTO;
import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import com.waldheim.calculator.drink.impl.db.entity.DrinkCategoryEntity;
import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import com.waldheim.calculator.person.impl.db.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculatorMapper {

    PersonDTO personEntityToPersonDTO(PersonEntity personEntity);

    PersonEntity personDTOToPersonEntity(PersonDTO personDTO);

    DrinkDTO drinkEntityDTOToDrinkDTO(DrinkEntity drinkEntity);

    DrinkEntity drinkDTOToDrinkEntity(DrinkDTO drinkDTO);

    DrinkCategoryEntity drinkCategoryDTOToDrinkCategoryEntity(DrinkCategoryDTO drinkCategoryDTO);

    DrinkCategoryDTO drinkCategoryEntityToDrinkCategoryDTO(DrinkCategoryEntity drinkCategoryEntity);
}
