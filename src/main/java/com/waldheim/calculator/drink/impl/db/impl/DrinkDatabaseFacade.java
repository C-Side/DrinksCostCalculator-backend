package com.waldheim.calculator.drink.impl.db.impl;

import com.waldheim.calculator.common.mapper.CalculatorMapper;
import com.waldheim.calculator.drink.impl.DTO.DrinkCategoryDTO;
import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import com.waldheim.calculator.drink.impl.db.DrinkDatabaseService;
import com.waldheim.calculator.drink.impl.db.entity.DrinkCategoryEntity;
import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.drink.impl.db.repository.DrinkCategoriesRepository;
import com.waldheim.calculator.drink.impl.db.repository.DrinkRepository;
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
    private final DrinkCategoriesRepository drinkCategoriesRepository;
    private final CalculatorMapper calculatorMapper;

    @Autowired
    public DrinkDatabaseFacade(DrinkRepository drinkRepository, DrinkCategoriesRepository drinkCategoriesRepository, CalculatorMapper calculatorMapper) {
        this.drinkRepository = drinkRepository;
        this.drinkCategoriesRepository = drinkCategoriesRepository;
        this.calculatorMapper = calculatorMapper;
    }

    @Override
    public List<DrinkDTO> getAllDrinks() {
        return drinkRepository.findAll().stream().map(calculatorMapper::drinkEntityDTOToDrinkDTO).collect(Collectors.toList());
    }

    @Override
    public DrinkDTO createDrink(DrinkDTO drinkDTO) throws BadRequestException {
        if (drinkDTO.id() != null) {
            throw new BadRequestException("A new drink cannot already have an ID");
        }
        DrinkEntity drinkEntity = drinkRepository.save(calculatorMapper.drinkDTOToDrinkEntity(drinkDTO));
        return calculatorMapper.drinkEntityDTOToDrinkDTO(drinkEntity);
    }

    @Override
    public DrinkDTO getDrinkById(Long id) {
        DrinkEntity drinkEntity = drinkRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return calculatorMapper.drinkEntityDTOToDrinkDTO(drinkEntity);
    }

    @Override
    public DrinkDTO updateDrink(DrinkDTO drinkDTO) {
        DrinkEntity drinkEntity = drinkRepository.save(calculatorMapper.drinkDTOToDrinkEntity(drinkDTO));
        return calculatorMapper.drinkEntityDTOToDrinkDTO(drinkEntity);
    }

    @Override
    public void deleteDrink(DrinkDTO drinkDTO) {
        drinkRepository.delete(calculatorMapper.drinkDTOToDrinkEntity(drinkDTO));
    }

    @Override
    public List<DrinkCategoryDTO> getAllDrinkCategories() {
        return drinkCategoriesRepository.findAll().stream().map(calculatorMapper::drinkCategoryEntityToDrinkCategoryDTO).collect(Collectors.toList());
    }

    @Override
    public DrinkCategoryDTO createDrinkCategory(DrinkCategoryDTO drinkCategoryDTO) throws BadRequestException {
        if (drinkCategoryDTO.id() != null) {
            throw new BadRequestException("A new drink category cannot already have an ID");
        }
        DrinkCategoryEntity drinkCategoryEntity = drinkCategoriesRepository.save(calculatorMapper.drinkCategoryDTOToDrinkCategoryEntity(drinkCategoryDTO));
        return calculatorMapper.drinkCategoryEntityToDrinkCategoryDTO(drinkCategoryEntity);
    }

    @Override
    public DrinkCategoryDTO updateDrinkCategory(DrinkCategoryDTO drinkCategoryDTO) {
        DrinkCategoryEntity drinkCategoryEntity = drinkCategoriesRepository.save(calculatorMapper.drinkCategoryDTOToDrinkCategoryEntity(drinkCategoryDTO));
        return calculatorMapper.drinkCategoryEntityToDrinkCategoryDTO(drinkCategoryEntity);
    }

    @Override
    public void deleteDrinkCategory(DrinkCategoryDTO drinkCategoryDTO) {
        drinkCategoriesRepository.delete(calculatorMapper.drinkCategoryDTOToDrinkCategoryEntity(drinkCategoryDTO));
    }
}
