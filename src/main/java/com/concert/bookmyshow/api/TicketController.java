package com.concert.bookmyshow.api;

import com.concert.bookmyshow.service.ConcertService;
import com.concert.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @PostMapping(path = "/api/ticket/register")
    public ResponseEntity<Object> registerTicket(
            @RequestParam long personId,
            @RequestParam long concertId,
            @RequestParam int ticketCount){
        return new ResponseEntity<>(ticketService.registerTicket(personId,concertId, ticketCount), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/api/ticket/concert-details")
    public ResponseEntity<Object> getPersonByConcertId(@RequestParam long concertId){
        return new ResponseEntity<>(ticketService.getAllPersonByConcertId(concertId),HttpStatus.OK);
    }

    @GetMapping(path = "/api/ticket/user-details")
    public ResponseEntity<Object> getAllConcertByUserId(@RequestParam long personId){
        return new ResponseEntity<>(ticketService.getAllConcertByPersonId(personId),HttpStatus.OK);
    }

    @GetMapping(path = "/api/ticket/concert-details/payment-status")
    public ResponseEntity<Object> getUsersByPaymentStatus(@RequestParam long concertId, @RequestParam boolean status){
        return new ResponseEntity<>(ticketService.getPersonByPaymentStatus(concertId, status),HttpStatus.OK);
    }

    @RequestMapping(path = "/api/ticket/payment/update-payment-status")
    public ResponseEntity<Object> updatePaymentStatus(@RequestParam long ticketId){
        return new ResponseEntity<>(ticketService.updatePaymentStatus(ticketId),HttpStatus.ACCEPTED);

    }
}
