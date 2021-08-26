package com.concert.bookmyshow.unitTest;

import com.concert.bookmyshow.entity.Concert;
import com.concert.bookmyshow.entity.Person;
import com.concert.bookmyshow.entity.Ticket;
import com.concert.bookmyshow.repository.PersonRepository;
import com.concert.bookmyshow.repository.TicketRepository;
import com.concert.bookmyshow.service.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TicketServiceTest {

    @Autowired
    TicketService ticketService;

    @MockBean
    TicketRepository ticketRepository;

    final long id = 1;
    Ticket ticket;

    @Before
    public void init(){
        final Person person = new Person("Prakash","champ","prakash@gmail.com");
        person.setId(1);
        final Concert concert = new Concert("Justin",1000.0,"America");
        concert.setId(1);
        ticket = new Ticket(person, concert, true, 4);
    }

    @Test
    public void testRegisterTicket(){
        Mockito.when(ticketRepository.save(Mockito.any())).thenReturn(ticket);
        final Ticket ticket1 = ticketRepository.save(ticket);
        assertEquals(ticket1.getNumberOfTickets(), 4);
    }
}
