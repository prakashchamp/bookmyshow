package com.concert.bookmyshow.service;

import com.concert.bookmyshow.entity.Ticket;

public interface EmailServiceInterface {
    public abstract String sendEmail(Ticket ticket);
}
