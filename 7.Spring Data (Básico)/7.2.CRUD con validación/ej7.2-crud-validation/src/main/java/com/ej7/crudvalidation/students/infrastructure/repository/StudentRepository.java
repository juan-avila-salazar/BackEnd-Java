package com.ej7.crudvalidation.students.infrastructure.repository;

import com.ej7.crudvalidation.students.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
