package com.ej7.crudvalidation.subjects.infrastructure.repository;

import com.ej7.crudvalidation.subjects.domain.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subjects, Integer> {
}
