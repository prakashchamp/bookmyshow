package com.concert.bookmyshow.service;

import com.concert.bookmyshow.entity.Person;

import java.util.List;

public interface PersonServiceInterface {
    public abstract Person createPerson(Person person);
    public abstract Person getPerson(long id);
    public abstract List<Person> getAllPerson();
    public abstract Person deletePerson(long id);
    public abstract Person updatePerson(long id, Person person);
}
