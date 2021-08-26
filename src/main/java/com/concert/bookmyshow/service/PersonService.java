package com.concert.bookmyshow.service;

import com.concert.bookmyshow.entity.Person;
import com.concert.bookmyshow.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceInterface {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person){
        Person _person = personRepository.save(person);
         return _person;
    }

    public Person getPerson(long id){
        return personRepository.findById(id).get();
    }

    public List<Person> getAllPerson(){
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    public Person deletePerson(long id){
        Person _person = personRepository.findById(id).get();
        personRepository.deleteById(id);
        return _person;
    }

    public Person updatePerson(long id, Person person){
        Optional<Person> _person = personRepository.findById(id);
        if (_person.isPresent()) {
            Person person1 = _person.get();
            person1.setFirstName(person.getFirstName());
            person1.setLastName(person.getLastName());
            person1.setEmailId(person.getEmailId());
            return personRepository.save(person1);
        }
        return null;
    }
}
