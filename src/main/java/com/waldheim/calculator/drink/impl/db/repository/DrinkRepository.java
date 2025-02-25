package com.waldheim.calculator.drink.impl.db.repository;

import com.waldheim.calculator.drink.impl.db.entity.DrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "drinks", path = "drinks")
public interface DrinkRepository extends PagingAndSortingRepository<DrinkEntity, Long>, JpaRepository<DrinkEntity, Long> {
}
