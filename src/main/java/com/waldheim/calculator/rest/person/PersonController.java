package com.waldheim.calculator.rest.person;

import com.waldheim.calculator.person.api.PersonService;
import com.waldheim.calculator.person.impl.DTO.DrinkAddedDTO;
import com.waldheim.calculator.person.impl.DTO.PersonDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) throws BadRequestException {
        return personService.createPerson(personDTO);
    }

    @PostMapping("/{id}/drinks")
    public void addDrinkToPerson(@PathVariable("id") Long id, @RequestBody DrinkAddedDTO drinkAddedDTO) {
        personService.addConsumedDrinkByPerson(id, drinkAddedDTO);
    }

    @GetMapping("/{id}/total")
    public BigDecimal getTotalCost(@PathVariable("id") Long id) {
        return personService.calculateTotalCostByPerson(id);
    }

    @PutMapping
    public PersonDTO updatePerson(@RequestBody PersonDTO personDTO) {
        return personService.updatePerson(personDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePerson(@RequestBody PersonDTO personDTO) {
        personService.deletePerson(personDTO);
        return ResponseEntity.noContent().build();
    }
}
