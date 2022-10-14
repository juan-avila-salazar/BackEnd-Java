package com.ej7.crudvalidation.teachers.infrastructure.repository;

import com.ej7.crudvalidation.teachers.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
