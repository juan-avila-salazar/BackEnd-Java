package com.ej7.crudvalidation.people.application;

import com.ej7.crudvalidation.exceptions.CustomError;
import com.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.ej7.crudvalidation.people.domain.Person;
import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoOut;
import com.ej7.crudvalidation.people.infrastructure.dto.PersonDtoIn;
import com.ej7.crudvalidation.people.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    //VALIDATIONS
    private void throwUnprocessableEntityException(String message) throws UnprocessableEntityException {
        throw new UnprocessableEntityException(new CustomError(new Date(System.currentTimeMillis()), 422, message));
    }
    private boolean checkPerson(Person person) throws UnprocessableEntityException{

        if (person.getUserName() == null )
            throwUnprocessableEntityException("User cannot be null");
        if (person.getUserName().length()<6 || person.getUserName().length()>10)
            throwUnprocessableEntityException(("the user must have min.6 characters and max.10 characters"));
        if (person.getPassword() == null )
            throwUnprocessableEntityException("Password cannot be null");
        if (person.getName() == null )
            throwUnprocessableEntityException("name cannot be null");
        if (person.getCompany_email() == null )
            throwUnprocessableEntityException("Company email cannot be null");
        if (person.getPersonal_email() == null )
            throwUnprocessableEntityException("Personal email cannot be null");
        if (person.getCity() == null )
            throwUnprocessableEntityException("City cannot be null");
        if (person.getActive() == null )
            throwUnprocessableEntityException("Password cannot be null");
        if (person.getCreated_date() == null )
            throwUnprocessableEntityException("Created date cannot be null");
        return true;
    }


    //CRUD//

    //GET//FULL PERSON TABLE
    @Override
    public List<PersonDtoOut> getAllPeople() {
        List<PersonDtoOut> list = new ArrayList<>();
        personRepository.findAll().forEach(p -> list.add(new PersonDtoOut(p)));
        return list;
    }
    //POST
    @Override
    public void addPerson(Person newPerson) throws UnprocessableEntityException {
        if (checkPerson(newPerson))
            personRepository.save(newPerson);
    }
    //PUT
    @Override
    public PersonDtoOut updatePerson(Integer id, PersonDtoIn updatedPerson) throws UnprocessableEntityException, EntityNotFoundException {
        Person person = new Person(updatedPerson);
        if (checkPerson(person)){
            Integer ident = getPersonById(id).getPerson_id();
            person.setPerson_id(ident);
            personRepository.save(person);
            return new PersonDtoOut(person);
        }
        return null;
    }
    //DELETE
    @Override
    public String deletePerson(Integer id) throws EntityNotFoundException {
        if (personRepository.findById(id).isPresent()) {
            try {
                personRepository.deleteById(id);
            }catch (EmptyResultDataAccessException exc){
                throw new EntityNotFoundException(new CustomError(new Date(System.currentTimeMillis()), 404, "Error! the customer does not exist"));
            }
            return "Customer removed successfully";
        }
        return "Error! the customer does not exist";
    }

    //Petitions//

    //SEARCH BY ID
    @Override
    public Person getPersonById(Integer id) throws EntityNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(new CustomError(new Date(System.currentTimeMillis()), 404, "This user does not exist")));
    }

    //SEARCH BY USER
    @Override
    public List<PersonDtoOut> getPersonByUsuario(String usuario) {
        List<Person> peopleRepository = (List<Person>) personRepository.findAll();
        List<PersonDtoOut> personByThisUser = new ArrayList<>();
        if (!peopleRepository.isEmpty()) {
            Stream<Person> personStream = peopleRepository.stream();
            personByThisUser = personStream.filter(person -> person.getUserName().equals(usuario))
                    .map(PersonDtoOut::new).toList();
        }
        return personByThisUser;
    }
}
