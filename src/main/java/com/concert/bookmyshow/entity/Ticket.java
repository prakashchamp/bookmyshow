package com.concert.bookmyshow.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = )
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @JoinColumn(name = "concert_id")
    Concert concert;

    private boolean paymentStatus;
    private int numberOfTickets;

    public Ticket(){}

    public Ticket(Person person, Concert concert, boolean paymentStatus, int numberOfTickets) {
        this.person = person;
        this.concert = concert;
        this.paymentStatus = paymentStatus;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
