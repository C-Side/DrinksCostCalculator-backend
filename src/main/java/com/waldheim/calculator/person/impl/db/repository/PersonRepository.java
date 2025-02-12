package com.waldheim.calculator.person.impl.db.repository;

import com.waldheim.calculator.person.impl.db.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
