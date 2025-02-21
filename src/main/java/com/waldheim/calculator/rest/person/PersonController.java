package com.waldheim.calculator.rest.person;

import com.waldheim.calculator.drink.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.person.api.PersonService;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> allPersons = personService.getAllPersons();
        return ResponseEntity.ok(allPersons);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personDTO));
    }

    @PutMapping
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.updatePerson(personDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePerson(@RequestBody PersonDTO personDTO) {
        personService.deletePerson(personDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/drinks")
    public ResponseEntity<Void> addDrinkToPerson(@PathVariable("id") Long id, @RequestBody DrinkAddedDTO drinkAddedDTO) {
        personService.addConsumedDrinkByPerson(id, drinkAddedDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<BigDecimal> getTotalCost(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.calculateTotalCostByPerson(id));
    }
}
