package com.concert.bookmyshow.service;

import com.concert.bookmyshow.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailServiceInterface, Runnable{

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendEmail(Ticket ticket) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String emailText = "Hai " + ticket.getPerson().getFirstName().toUpperCase()+
                ", thanks for registering. Please complete the payment process to book your ticket for the concert " +
                ticket.getConcert().getTitle().toUpperCase()+"\n"+
                "You can complete the payment process using the below link\n"+
                "http://localhost:8080/api/ticket/payment/update-payment-status?ticketId="+ticket.getId().toString();

        mailMessage.setTo(ticket.getPerson().getEmailId());
        mailMessage.setSubject("Prakash BookMyShow");
        mailMessage.setText(emailText);

        mailMessage.setFrom("prakashchamp13@gmail.com");

        javaMailSender.send(mailMessage);
        return null;
    }

    @Override
    public void run() {

    }
}
