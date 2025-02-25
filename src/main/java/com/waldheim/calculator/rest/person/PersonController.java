package com.waldheim.calculator.rest.person;

import com.waldheim.calculator.person.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@RepositoryRestController(path = "persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<BigDecimal> getTotalCost(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.calculateTotalCostByPerson(id));
    }
}
