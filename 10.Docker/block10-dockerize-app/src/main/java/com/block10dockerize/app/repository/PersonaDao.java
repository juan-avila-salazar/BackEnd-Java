package com.block10dockerize.app.repository;


import com.block10dockerize.app.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaDao extends JpaRepository<Persona, Integer> {
    List<Persona> findByname(String name);

}