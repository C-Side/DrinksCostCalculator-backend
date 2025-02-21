package com.waldheim.calculator.common.mapper;

import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import com.waldheim.calculator.drink.impl.DTO.DrinkKindDTO;
import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.drink.impl.db.entity.DrinkKindEntity;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import com.waldheim.calculator.person.impl.db.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculatorMapper {

    PersonDTO personEntityToPersonDTO(PersonEntity personEntity);

    PersonEntity personDTOToPersonEntity(PersonDTO personDTO);

    DrinkDTO drinkEntityDTOToDrinkDTO(DrinkEntity drinkEntity);

    DrinkEntity drinkDTOToDrinkEntity(DrinkDTO drinkDTO);

    DrinkKindEntity drinkKindDTOToDrinkKindEntity(DrinkKindDTO drinkKindDTO);

    DrinkKindDTO drinkKindEntityDTOToDrinkKindDTO(DrinkKindEntity drinkKindEntity);
}
