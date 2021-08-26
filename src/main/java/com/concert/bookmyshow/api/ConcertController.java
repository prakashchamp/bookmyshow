package com.concert.bookmyshow.api;

import com.concert.bookmyshow.entity.Concert;
import com.concert.bookmyshow.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConcertController {

    private final ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping(path = "/api/concerts")
    public ResponseEntity<Object> getAllConcerts(){
        return new ResponseEntity<>(concertService.getAllConcerts(), HttpStatus.OK);
    }

    @GetMapping(path = "/api/concerts/{id}")
    public ResponseEntity<Object> getConcert(@PathVariable("id") Long id){
        return new ResponseEntity<>(concertService.getConcert(id), HttpStatus.OK);
    }

    @PostMapping(path = "/api/concerts/create")
    public ResponseEntity<Object> createConcert(@RequestBody Concert concert){
        return new ResponseEntity<>(concertService.createConcert(concert), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/concert/delete/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable("id") Long id){
        return new ResponseEntity<>(concertService.deleteConcert(id), HttpStatus.OK);
    }

    @PutMapping(path = "/api/concert/update/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable("id") long id,  @RequestBody Concert concert){
        return new ResponseEntity<>(concertService.updateConcert(id, concert), HttpStatus.OK);
    }
}
