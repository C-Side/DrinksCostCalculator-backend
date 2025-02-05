package com.waldheim.calculator.impl.db.repository;

import com.waldheim.calculator.impl.db.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
