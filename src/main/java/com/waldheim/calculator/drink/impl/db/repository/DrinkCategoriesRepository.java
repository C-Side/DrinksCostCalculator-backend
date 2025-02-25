package com.waldheim.calculator.drink.impl.db.repository;

import com.waldheim.calculator.drink.impl.db.entity.DrinkCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "drink-categories", path = "drink-categories")
public interface DrinkCategoriesRepository extends PagingAndSortingRepository<DrinkCategoryEntity, Long>, JpaRepository<DrinkCategoryEntity, Long> {
}
