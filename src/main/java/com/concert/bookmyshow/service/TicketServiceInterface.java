package com.concert.bookmyshow.service;

import com.concert.bookmyshow.entity.Ticket;

import java.util.List;

public interface TicketServiceInterface {
    public abstract Ticket registerTicket(long personId, long concertId, int ticketCount);
    public abstract List<Ticket> getAllPersonByConcertId(long concertId);
    public abstract List<Ticket> getAllConcertByPersonId(long userId);
    public abstract List<Ticket> getPersonByPaymentStatus(long concertId, boolean status);
    public abstract Ticket deleteTicket(long id);
    public abstract Ticket getTicket(long id);
    public abstract Ticket updatePaymentStatus(long id);
    public abstract String moveToPaymentQueue(Ticket ticket);
}
