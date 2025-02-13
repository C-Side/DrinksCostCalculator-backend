package com.waldheim.calculator.mapper;

import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import com.waldheim.calculator.person.impl.db.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculatorMapper {

    PersonDTO personEntityToPersonDto(PersonEntity personEntity);

    PersonEntity personDtoToPersonEntity(PersonDTO personDto);

    DrinkDTO drinkEntityDtoToDrinkDto(DrinkEntity drinkEntity);

    DrinkEntity drinkDtoToDrinkEntity(DrinkDTO drinkDTO);
}
