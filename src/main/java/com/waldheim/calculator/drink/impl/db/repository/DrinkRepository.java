package com.waldheim.calculator.drink.impl.db.repository;

import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<DrinkEntity, Long> {
}
