package com.waldheim.calculator.drink.impl.facade;

import com.waldheim.calculator.drink.api.DrinkKindService;
import com.waldheim.calculator.drink.impl.DTO.DrinkKindDTO;
import com.waldheim.calculator.drink.impl.db.DrinkDatabaseService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkKindFacade implements DrinkKindService {

    private final DrinkDatabaseService drinkDatabaseService;

    @Autowired
    public DrinkKindFacade(DrinkDatabaseService drinkDatabaseService) {
        this.drinkDatabaseService = drinkDatabaseService;
    }

    @Override
    public List<DrinkKindDTO> getAllDrinkKinds() {
        return drinkDatabaseService.getAllDrinkKinds();
    }

    @Override
    public DrinkKindDTO createDrinkKind(DrinkKindDTO drinkKindDTO) throws BadRequestException {
        return drinkDatabaseService.createDrinkKind(drinkKindDTO);
    }

    @Override
    public DrinkKindDTO updateDrinkKind(DrinkKindDTO drinkKindDTO) {
        return drinkDatabaseService.updateDrinkKind(drinkKindDTO);
    }

    @Override
    public void deleteDrinkKind(DrinkKindDTO drinkKindDTO) {
        drinkDatabaseService.deleteDrinkKind(drinkKindDTO);
    }
}
