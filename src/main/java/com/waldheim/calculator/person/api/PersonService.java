package com.waldheim.calculator.person.api;


import java.math.BigDecimal;

public interface PersonService {
    BigDecimal calculateTotalCostByPerson(Long personId);
}
