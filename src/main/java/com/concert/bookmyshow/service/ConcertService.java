package com.concert.bookmyshow.service;

import com.concert.bookmyshow.entity.Concert;
import com.concert.bookmyshow.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcertService implements ConcertServiceInterface{

    private final ConcertRepository concertRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    public Concert createConcert(Concert concert){
        Concert _concert = concertRepository.save(concert);
        return _concert;
    }

    public Concert getConcert(long id){
        Concert concert = concertRepository.findById(id).get();
        return concert;
    }

    public List<Concert> getAllConcerts(){
        List<Concert> concertList = concertRepository.findAll();
        return concertList;
    }

    public Concert deleteConcert(long id){
        Concert concert = concertRepository.findById(id).get();
        concertRepository.deleteById(id);
        return concert;
    }

    public Concert updateConcert(long id, Concert concert){
        Optional<Concert> _concert = concertRepository.findById(id);
        if (_concert.isPresent()) {
            Concert concert1 = _concert.get();
            concert1.setTitle(concert.getTitle());
            concert1.setPrice(concert.getPrice());
            concert1.setVenue(concert.getVenue());
            return concertRepository.save(concert1);
        }
        return null;
    }
}
