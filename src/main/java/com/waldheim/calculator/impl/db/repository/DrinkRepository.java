package com.waldheim.calculator.impl.db.repository;

import com.waldheim.calculator.impl.db.entity.DrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<DrinkEntity, Long> {
}
