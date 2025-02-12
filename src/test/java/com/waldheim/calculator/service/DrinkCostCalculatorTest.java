package com.waldheim.calculator.service;

import com.waldheim.calculator.person.api.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DrinkCostCalculatorTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testCalculateTotalCost() {
        BigDecimal totalCost = personService.calculateTotalCostByPerson(1L);
        assertThat(totalCost).isEqualTo(new BigDecimal("13.55"));
    }
}
