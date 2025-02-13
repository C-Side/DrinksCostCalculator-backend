package com.waldheim.calculator.rest.drink;

import com.waldheim.calculator.drink.api.DrinkService;
import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public List<DrinkDTO> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @GetMapping("/{id}")
    public DrinkDTO getDrinkById(@PathVariable Long id) {
        return drinkService.getDrinkById(id);
    }

    @PostMapping
    public DrinkDTO createDrink(@RequestBody DrinkDTO drinkDTO) throws BadRequestException {
        return drinkService.createDrink(drinkDTO);
    }

    @PutMapping
    public DrinkDTO updateDrink(@RequestBody DrinkDTO drinkDTO) {
        return drinkService.updateDrink(drinkDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDrink(@RequestBody DrinkDTO drinkDTO) {
        drinkService.deleteDrink(drinkDTO);
        return ResponseEntity.noContent().build();
    }
}
