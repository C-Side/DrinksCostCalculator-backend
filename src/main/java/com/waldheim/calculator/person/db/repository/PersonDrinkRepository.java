package com.waldheim.calculator.person.db.repository;

import com.waldheim.calculator.person.db.entity.PersonDrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigDecimal;

@RepositoryRestResource(collectionResourceRel = "person-drinks", path = "person-drinks")
public interface PersonDrinkRepository extends JpaRepository<PersonDrinkEntity, Long> {

    @Query(value = "SELECT SUM(drinks.price * person_drinks.quantity) AS total_cost" +
            " FROM person_drinks" +
            " JOIN drinks ON person_drinks.drink_id = drinks.id" +
            " WHERE person_drinks.person_id = :personId", nativeQuery = true)
    BigDecimal findTotalCostByPerson(@Param("personId") long personId);
}
