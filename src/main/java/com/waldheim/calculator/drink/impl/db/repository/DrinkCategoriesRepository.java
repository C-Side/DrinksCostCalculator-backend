package com.waldheim.calculator.drink.impl.db.repository;

import com.waldheim.calculator.drink.impl.db.entity.DrinkCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkCategoriesRepository extends JpaRepository<DrinkCategoryEntity, Long> {
}
