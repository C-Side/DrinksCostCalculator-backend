package com.waldheim.calculator.rest;


import com.waldheim.calculator.impl.DTO.DrinkDTO;
import com.waldheim.calculator.impl.DTO.PersonDTO;
import com.waldheim.calculator.impl.facade.DrinkCostCalculatorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
class DrinkCostCalculatorController {
    
    private final DrinkCostCalculatorFacade drinkCostCalculatorFacade;

    @Autowired
    public DrinkCostCalculatorController(DrinkCostCalculatorFacade drinkCostCalculatorFacade) {
        this.drinkCostCalculatorFacade = drinkCostCalculatorFacade;
    }

    @PostMapping("/persons")
    public Long createPerson(@RequestBody PersonDTO person) {
        return drinkCostCalculatorFacade.createPerson(person);
    }

    @PostMapping("/persons/{id}/drinks")
    public void addDrinkToPerson(@PathVariable Long id, @RequestBody DrinkDTO drink) {
        drinkCostCalculatorFacade.addConsumedDrinkByPerson(id, drink);
    }

    @GetMapping("/persons/{id}/total")
    public double getTotalCost(@PathVariable Long id) {
        return drinkCostCalculatorFacade.calculateTotalCostByPerson(id);
    }
}
