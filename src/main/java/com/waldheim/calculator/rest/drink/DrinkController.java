package com.waldheim.calculator.rest.drink;

import com.waldheim.calculator.drink.api.DrinkService;
import com.waldheim.calculator.drink.impl.DTO.DrinkDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<DrinkDTO> getDrinkById(@PathVariable Long id) {
        return ResponseEntity.ok(drinkService.getDrinkById(id));
    }

    @GetMapping
    public ResponseEntity<List<DrinkDTO>> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }

    @PostMapping
    public ResponseEntity<DrinkDTO> createDrink(@RequestBody DrinkDTO drinkDTO) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(drinkService.createDrink(drinkDTO));
    }

    @PutMapping
    public ResponseEntity<DrinkDTO> updateDrink(@RequestBody DrinkDTO drinkDTO) {
        return ResponseEntity.ok(drinkService.updateDrink(drinkDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDrink(@RequestBody DrinkDTO drinkDTO) {
        drinkService.deleteDrink(drinkDTO);
        return ResponseEntity.noContent().build();
    }
}
