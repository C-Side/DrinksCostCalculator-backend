package com.waldheim.calculator.person.db.repository;

import com.waldheim.calculator.person.db.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, Long>, JpaRepository<PersonEntity, Long> {

}
