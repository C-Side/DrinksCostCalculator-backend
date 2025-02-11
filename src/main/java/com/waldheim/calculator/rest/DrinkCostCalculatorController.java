package com.waldheim.calculator.rest;


import com.waldheim.calculator.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.facade.DrinkCostCalculatorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
class DrinkCostCalculatorController {
    
    private final DrinkCostCalculatorFacade drinkCostCalculatorFacade;

    @Autowired
    public DrinkCostCalculatorController(DrinkCostCalculatorFacade drinkCostCalculatorFacade) {
        this.drinkCostCalculatorFacade = drinkCostCalculatorFacade;
    }

    @GetMapping("/persons")
    public List<PersonDTO> getAllPersons() {
        return drinkCostCalculatorFacade.getAllPersons();
    }

    @PostMapping("/persons")
    public Long createPerson(@RequestBody PersonDTO personDTO) {
        return drinkCostCalculatorFacade.createPerson(personDTO);
    }

    @GetMapping("/drinks")
    public List<DrinkDTO> getAllDrinks() {
        return drinkCostCalculatorFacade.getAllDrinks();
    }

    @PostMapping("/drinks")
    public Long createDrink(@RequestBody DrinkDTO drinkDTO) {
        return drinkCostCalculatorFacade.createDrink(drinkDTO);
    }

    @PostMapping("/persons/{id}/drinks")
    public void addDrinkToPerson(@PathVariable("id") Long id, @RequestBody DrinkAddedDTO drinkAddedDTO) {
        drinkCostCalculatorFacade.addConsumedDrinkByPerson(id, drinkAddedDTO);
    }

    @GetMapping("/persons/{id}/total")
    public BigDecimal getTotalCost(@PathVariable("id") Long id) {
        return drinkCostCalculatorFacade.calculateTotalCostByPerson(id);
    }
}
