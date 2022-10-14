package com.ej7.crudvalidation.people.application;

import com.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.ej7.crudvalidation.people.domain.Person;
import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoIn;
import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoOut;

import java.io.FileNotFoundException;
import java.util.List;

public interface PersonService {
    //CRUD//
    //GET
    List<PersonDtoOut> getAllPeople();
    //POST
    void addPerson(Person person)throws UnprocessableEntityException;
    //PUT
    public PersonDtoOut updatePerson(Integer id, PersonDtoIn person) throws UnprocessableEntityException, EntityNotFoundException;
    //DELETE
    String deletePerson(Integer id) throws EntityNotFoundException;

    //Petitions//
    Person getPersonById(Integer id) throws EntityNotFoundException, FileNotFoundException;
    List<PersonDtoOut> getPersonByUsuario(String usuario);

}
