package com.waldheim.calculator.drink.impl.db.impl;

import com.waldheim.calculator.common.mapper.CalculatorMapper;
import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import com.waldheim.calculator.drink.impl.DTO.DrinkKindDTO;
import com.waldheim.calculator.drink.impl.db.DrinkDatabaseService;
import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.drink.impl.db.entity.DrinkKindEntity;
import com.waldheim.calculator.drink.impl.db.repository.DrinkKindsRepository;
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
    private final DrinkKindsRepository drinkKindsRepository;
    private final CalculatorMapper calculatorMapper;

    @Autowired
    public DrinkDatabaseFacade(DrinkRepository drinkRepository, DrinkKindsRepository drinkKindsRepository, CalculatorMapper calculatorMapper) {
        this.drinkRepository = drinkRepository;
        this.drinkKindsRepository = drinkKindsRepository;
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
    public List<DrinkKindDTO> getAllDrinkKinds() {
        return drinkKindsRepository.findAll().stream().map(calculatorMapper::drinkKindEntityDTOToDrinkKindDTO).collect(Collectors.toList());
    }

    @Override
    public DrinkKindDTO createDrinkKind(DrinkKindDTO drinkKindDTO) throws BadRequestException {
        if (drinkKindDTO.id() != null) {
            throw new BadRequestException("A new drink kind cannot already have an ID");
        }
        DrinkKindEntity drinkKindEntity = drinkKindsRepository.save(calculatorMapper.drinkKindDTOToDrinkKindEntity(drinkKindDTO));
        return calculatorMapper.drinkKindEntityDTOToDrinkKindDTO(drinkKindEntity);
    }

    @Override
    public DrinkKindDTO updateDrinkKind(DrinkKindDTO drinkKindDTO) {
        DrinkKindEntity drinkKindEntity = drinkKindsRepository.save(calculatorMapper.drinkKindDTOToDrinkKindEntity(drinkKindDTO));
        return calculatorMapper.drinkKindEntityDTOToDrinkKindDTO(drinkKindEntity);
    }

    @Override
    public void deleteDrinkKind(DrinkKindDTO drinkKindDTO) {
        drinkKindsRepository.delete(calculatorMapper.drinkKindDTOToDrinkKindEntity(drinkKindDTO));
    }
}
