package com.waldheim.calculator.person.impl.db;


import java.math.BigDecimal;

public interface PersonDatabaseService {

    BigDecimal getTotalCost(Long personId);
}
