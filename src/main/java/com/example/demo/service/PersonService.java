/*
    Services contain the business logic of the application. They handle complex operations, coordinate
    interactions between different components, and perform data manipulation or processing tasks.
    Services encapsulate reusable and independent units of functionality.

	Best practices for services include:

    * Keeping services focused and cohesive: Each service should have a specific responsibility or
    functionality and avoid becoming overly complex.

    * Applying the Dependency Injection (DI) principle: Services should rely on interfaces rather than
    concrete implementations, allowing for easier testing and decoupling from specific implementations.

    * Enforcing transactional boundaries: Use transactions to ensure data consistency when multiple
    operations need to be performed atomically.
 */
package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
       return personDao.updatePersonById(id, newPerson);
    }
}
