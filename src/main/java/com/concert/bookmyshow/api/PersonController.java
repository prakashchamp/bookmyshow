package com.concert.bookmyshow.api;

import com.concert.bookmyshow.entity.Person;
import com.concert.bookmyshow.service.ConcertService;
import com.concert.bookmyshow.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @GetMapping(path = "/api/person")
    public ResponseEntity<Object> getAllPerson(){
        return new ResponseEntity<>(personService.getAllPerson(), HttpStatus.OK);
    }

    @GetMapping(path = "/api/person/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable("id") Long id){
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping(path = "/api/person/create")
    public ResponseEntity<Object> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/person/delete/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable("id") Long id){
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.OK);
    }

    @PutMapping(path = "/api/person/update/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable("id") long id,  @RequestBody Person person){
        return new ResponseEntity<>(personService.updatePerson(id, person), HttpStatus.OK);
    }

}
