package com.waldheim.calculator.drink.impl.db.impl;

import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import com.waldheim.calculator.drink.impl.db.DrinkDatabaseService;
import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.drink.impl.db.repository.DrinkRepository;
import com.waldheim.calculator.mapper.CalculatorMapper;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
public class DrinkDatabaseFacade implements DrinkDatabaseService {

    private final DrinkRepository drinkRepository;
    private final CalculatorMapper calculatorMapper;

    @Autowired
    public DrinkDatabaseFacade(DrinkRepository drinkRepository, CalculatorMapper calculatorMapper) {
        this.drinkRepository = drinkRepository;
        this.calculatorMapper = calculatorMapper;
    }

    @Override
    public List<DrinkDTO> getAllDrinks() {
        return drinkRepository.findAll().stream().map(calculatorMapper::drinkEntityDtoToDrinkDto).collect(Collectors.toList());
    }

    @Override
    public DrinkDTO createDrink(DrinkDTO drinkDTO) throws BadRequestException {
        if (drinkDTO.id() != null) {
            throw new BadRequestException("A new drink cannot already have an ID");
        }
        DrinkEntity drinkEntity = drinkRepository.save(calculatorMapper.drinkDtoToDrinkEntity(drinkDTO));
        return calculatorMapper.drinkEntityDtoToDrinkDto(drinkEntity);
    }

    @Override
    public DrinkDTO getDrinkById(Long id) {
        DrinkEntity drinkEntity = drinkRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return calculatorMapper.drinkEntityDtoToDrinkDto(drinkEntity);
    }

    @Override
    public DrinkDTO updateDrink(DrinkDTO drinkDTO) {
        DrinkEntity drinkEntity = drinkRepository.save(calculatorMapper.drinkDtoToDrinkEntity(drinkDTO));
        return calculatorMapper.drinkEntityDtoToDrinkDto(drinkEntity);
    }

    @Override
    public void deleteDrink(DrinkDTO drinkDTO) {
        drinkRepository.delete(calculatorMapper.drinkDtoToDrinkEntity(drinkDTO));
    }
}
