package com.waldheim.calculator.impl.db.repository;

import com.waldheim.calculator.impl.db.entity.DrinkEntity;
import com.waldheim.calculator.impl.db.entity.PersonDrinkEntity;
import com.waldheim.calculator.impl.db.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface PersonDrinkRepository extends JpaRepository<PersonDrinkEntity, Long> {
    PersonDrinkEntity findByPersonAndDrink(PersonEntity person, DrinkEntity drink);
    @Query(value = "SELECT SUM(d.price * p_d.quantity) AS total_cost" +
            "FROM PersonDrinkEntity p_d" +
            "JOIN drinks d ON p_d.drink_id = d.id" +
            "WHERE p_d.person_id = :personId", nativeQuery = true)
    List<Object> findTotalCostByPerson(@Param("personId") long personId);
}
