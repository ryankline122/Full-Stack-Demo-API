/*
  Controllers are responsible for handling incoming requests and returning the appropriate response.
  They act as intermediaries between the user interface (usually the web browser or mobile app) and
  the backend services. Controllers receive the requests, extract the necessary data, and invoke the
  appropriate services to process the request. They also handle any necessary data transformations and
  return the response to the client.

  Best practices for controllers include:

  * Keeping them lightweight: Controllers should focus on request handling and delegate complex logic to
  other components, such as services.

  * Following the Single Responsibility Principle (SRP): Each controller should have a clear and well-defined
  purpose, handling requests related to a specific resource or functionality.

  * Using appropriate HTTP methods: Map the controller methods to the appropriate HTTP methods
  (GET, POST, PUT, DELETE, etc.) based on the desired behavior.

 */
package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
       personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
