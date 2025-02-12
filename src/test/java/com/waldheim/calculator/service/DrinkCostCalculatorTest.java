package com.waldheim.calculator.service;

import com.waldheim.calculator.api.DrinkCostCalculatorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DrinkCostCalculatorTest {

    @Autowired
    private DrinkCostCalculatorService drinkCostCalculatorService;

    @Test
    public void testCalculateTotalCost() {
        BigDecimal totalCost = drinkCostCalculatorService.calculateTotalCostByPerson(1L);
        assertThat(totalCost).isEqualTo(new BigDecimal("13.55"));
    }
}
