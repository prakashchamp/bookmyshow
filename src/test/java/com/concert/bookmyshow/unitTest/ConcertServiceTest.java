package com.concert.bookmyshow.unitTest;

import com.concert.bookmyshow.entity.Concert;
import com.concert.bookmyshow.entity.Person;
import com.concert.bookmyshow.repository.ConcertRepository;
import com.concert.bookmyshow.service.ConcertService;
import org.checkerframework.checker.units.qual.C;
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
public class ConcertServiceTest {
    @Autowired
    ConcertService concertService;

    @MockBean
    ConcertRepository concertRepository;

    final long id =1;
    Concert concert;
    Concert concert2;

    @Before
    public void init(){
        this.concert =  new Concert("Justin",1000.0,"America");
        this.concert2 =  new Concert("Jackson",1000.0,"America");
        this.concert.setId(1);
    }

    @Test
    public void testCreateConcert(){
        Mockito.when(concertRepository.save(Mockito.any())).thenReturn(concert);
        final Concert concert1 = concertRepository.save(concert);
        assertEquals(concert1.getTitle(), "Justin");

    }

    @Test
    public void testGetConcert(){
        Mockito.when(concertRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(concert));
        final Optional<Concert> concert1 = concertRepository.findById(id);
        assertEquals(concert1.get().getTitle(), "Justin");
    }

    @Test
    public void testDeleteConcert(){
        Mockito.when(concertRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(concert));
        final Optional<Concert> concert1 = concertRepository.findById(id);
        concertRepository.deleteById(id);
        assertEquals(concert1.get().getTitle(), "Justin");
    }

    @Test
    public void testUpdatePerson(){
        Mockito.when(concertRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(concert));
        Mockito.when(concertRepository.save(Mockito.any())).thenReturn(concert);
        final Optional<Concert> concert1 = concertRepository.findById(id);
        concert1.get().setTitle("Jackson");
        final Concert concert2 = concertRepository.save(concert1.get());
        assertEquals(concert2.getTitle(), "Jackson");
    }
}
