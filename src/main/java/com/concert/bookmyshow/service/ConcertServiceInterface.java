package com.concert.bookmyshow.service;

import com.concert.bookmyshow.entity.Concert;

import java.util.List;

public interface ConcertServiceInterface {
    public abstract Concert createConcert(Concert concert);
    public abstract Concert getConcert(long id);
    public abstract List<Concert> getAllConcerts();
    public abstract Concert deleteConcert(long id);
    public abstract Concert updateConcert(long id, Concert concert);
}
