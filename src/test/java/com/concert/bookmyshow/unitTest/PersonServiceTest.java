package com.concert.bookmyshow.unitTest;

import com.concert.bookmyshow.entity.Concert;
import com.concert.bookmyshow.entity.Person;
import com.concert.bookmyshow.repository.PersonRepository;
import com.concert.bookmyshow.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {
    @Autowired
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    final long id = 1;
    Person person;
    Person person2;

    @Before
    public void init(){
       this.person = new Person("Prakash","champ","prakash@gmail.com");
       this.person2 = new Person("Ramesh","champ","prakash@gmail.com");
       this.person.setId(1);
    }

    @Test
    public void testCreatePerson(){
        Mockito.when(personRepository.save(Mockito.any())).thenReturn(person);
        final Person person1 = personRepository.save(person);
        assertEquals(person1.getFirstName(), "Prakash");
    }

    @Test
    public void testGetPerson(){
        Mockito.when(personRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(person));
        final Optional<Person> person1 = personRepository.findById(id);
        assertEquals(person1.get().getFirstName(), "Prakash");
    }

    @Test
    public void testDeletePerson(){
        Mockito.when(personRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(person));
        final Optional<Person> person1 = personRepository.findById(id);
        personRepository.deleteById(id);
        assertEquals(person1.get().getFirstName(), "Prakash");
    }

    @Test
    public void testUpdatePerson(){
        Mockito.when(personRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(person));
        Mockito.when(personRepository.save(Mockito.any())).thenReturn(person);
        final Optional<Person> person1 = personRepository.findById(id);
        person1.get().setFirstName("Ramesh");
        final Person person2 = personRepository.save(person1.get());
        assertEquals(person2.getFirstName(), "Ramesh");
    }
}
