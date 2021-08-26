package com.concert.bookmyshow.service;

import com.concert.bookmyshow.entity.Concert;
import com.concert.bookmyshow.entity.Person;
import com.concert.bookmyshow.entity.Ticket;
import com.concert.bookmyshow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TicketService implements TicketServiceInterface {

    private final ConcertService concertService;
    private final PersonService personService;
    private final EmailService emailService;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(ConcertService concertService, PersonService personService, EmailService emailService, TicketRepository ticketRepository) {
        this.concertService = concertService;
        this.personService = personService;
        this.emailService = emailService;
        this.ticketRepository = ticketRepository;
    }

    public Ticket registerTicket(long personId, long concertId, int ticketCount){
        Person person = personService.getPerson(personId);
        Concert concert = concertService.getConcert(concertId);
        Ticket ticket = ticketRepository.save(new Ticket(person,concert,false,ticketCount));
        moveToPaymentQueue(ticket);
        return ticket;
    }

    public List<Ticket> getAllPersonByConcertId(long concertId){
         return ticketRepository.getAllPersonByConcertId(concertId);
    }

    public List<Ticket> getAllConcertByPersonId(long userId){
        return ticketRepository.getAllConcertByPersonId(userId);
    }

    public List<Ticket> getPersonByPaymentStatus(long concertId, boolean status){
        return ticketRepository.getPersonByPaymentStatus(concertId, status);
    }

    public Ticket deleteTicket(long id){
        Ticket ticket = ticketRepository.findById(id).get();
        ticketRepository.deleteById(id);
        return ticket;
    }

    public Ticket getTicket(long id){
        return ticketRepository.findById(id).get();
    }

    public Ticket updatePaymentStatus(long id){
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setPaymentStatus(true);
        ticketRepository.save(ticket);
        return ticket;
    }

    public String moveToPaymentQueue(Ticket ticket){
        List<Ticket> userQueue = new ArrayList<>();
        userQueue.add(ticket);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (Ticket ticket1: userQueue) {
            Runnable runnable = () -> {
                emailService.sendEmail(ticket1);
            };
            executor.execute(runnable);
        }
        return "emailService.sendEmail(ticket)";
    }
}
