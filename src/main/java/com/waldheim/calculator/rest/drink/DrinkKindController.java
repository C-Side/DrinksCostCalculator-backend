package com.waldheim.calculator.rest.drink;

import com.waldheim.calculator.drink.api.DrinkKindService;
import com.waldheim.calculator.drink.impl.DTO.DrinkKindDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drink-kinds")
public class DrinkKindController {

    private final DrinkKindService drinkKindService;

    @Autowired
    public DrinkKindController(DrinkKindService drinkKindService) {
        this.drinkKindService = drinkKindService;
    }

    @GetMapping
    public ResponseEntity<List<DrinkKindDTO>> getAllDrinkKinds() {
        return ResponseEntity.ok(drinkKindService.getAllDrinkKinds());
    }

    @PostMapping
    public ResponseEntity<DrinkKindDTO> createDrinkKind(@RequestBody DrinkKindDTO drinkKindDTO) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(drinkKindService.createDrinkKind(drinkKindDTO));
    }

    @PutMapping
    public ResponseEntity<DrinkKindDTO> updateDrinkKind(@RequestBody DrinkKindDTO drinkKindDTO) {
        return ResponseEntity.ok(drinkKindService.updateDrinkKind(drinkKindDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDrinkKind(@RequestBody DrinkKindDTO drinkKindDTO) {
        drinkKindService.deleteDrinkKind(drinkKindDTO);
        return ResponseEntity.noContent().build();
    }
}
