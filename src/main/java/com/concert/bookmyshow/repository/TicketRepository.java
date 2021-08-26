package com.concert.bookmyshow.repository;

import com.concert.bookmyshow.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Query(value = "SELECT * FROM Ticket WHERE concert_id=:id", nativeQuery = true)
    List<Ticket> getAllPersonByConcertId(@Param("id") long id);
    @Query(value = "SELECT * FROM Ticket WHERE (concert_id=:id AND payment_status=:status)", nativeQuery = true)
    List<Ticket> getPersonByPaymentStatus(@Param("id") long id, @Param("status") boolean status);
    @Query(value = "SELECT * FROM Ticket WHERE person_id=:id", nativeQuery = true)
    List<Ticket> getAllConcertByPersonId(@Param("id") long id);
}
