package com.waldheim.calculator.drink.impl.db.repository;

import com.waldheim.calculator.drink.impl.db.entity.DrinkKindEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkKindsRepository extends JpaRepository<DrinkKindEntity, Long> {
}
