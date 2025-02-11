package com.waldheim.calculator.impl.mapper;

import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.impl.db.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CalculatorMapper {

    PersonDTO personEntityToPersonDto(PersonEntity personEntity);
    PersonEntity personDtoToPersonEntity(PersonDTO personDto);
    DrinkDTO drinkEntityDtoToDrinkDto(DrinkEntity drinkEntity);
    DrinkEntity drinkDtoToDrinkEntity(DrinkDTO drinkDTO);
}
