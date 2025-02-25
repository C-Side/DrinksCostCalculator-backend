package com.waldheim.calculator.rest.drink;

import com.waldheim.calculator.drink.api.DrinkCategoriesService;
import com.waldheim.calculator.drink.impl.DTO.DrinkCategoryDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drink-categories")
public class DrinkCategoriesController {

    private final DrinkCategoriesService drinkCategoriesService;

    @Autowired
    public DrinkCategoriesController(DrinkCategoriesService drinkCategoriesService) {
        this.drinkCategoriesService = drinkCategoriesService;
    }

    @GetMapping
    public ResponseEntity<List<DrinkCategoryDTO>> getAllDrinkCategories() {
        return ResponseEntity.ok(drinkCategoriesService.getAllDrinkCategories());
    }

    @PostMapping
    public ResponseEntity<DrinkCategoryDTO> createDrinkCategory(@RequestBody DrinkCategoryDTO drinkCategoryDTO) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(drinkCategoriesService.createDrinkCategory(drinkCategoryDTO));
    }

    @PutMapping
    public ResponseEntity<DrinkCategoryDTO> updateDrinkCategory(@RequestBody DrinkCategoryDTO drinkCategoryDTO) {
        return ResponseEntity.ok(drinkCategoriesService.updateDrinkCategory(drinkCategoryDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDrinkCategory(@RequestBody DrinkCategoryDTO drinkCategoryDTO) {
        drinkCategoriesService.deleteDrinkCategory(drinkCategoryDTO);
        return ResponseEntity.noContent().build();
    }
}
