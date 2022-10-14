package com.ej7.crudvalidation.people.infrastructure.repository;

import com.ej7.crudvalidation.people.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
