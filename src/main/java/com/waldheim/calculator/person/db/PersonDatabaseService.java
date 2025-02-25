package com.waldheim.calculator.person.db;


import java.math.BigDecimal;

public interface PersonDatabaseService {

    BigDecimal getTotalCost(Long personId);
}
