package org.generation.SpringAssessment.repository;

import org.generation.SpringAssessment.repository.entity.Item;
import org.springframework.data.repository.CrudRepository;

// The ItemRepository created is to extend the CRUDRepository provided by Spring Data JPA package
// This will be AUTO IMPLEMENTED by Spring
// CRUD = Create, Read, Update, Delete
public interface ItemRepository extends CrudRepository<Item, Integer>
{
}

// Reference Link: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html