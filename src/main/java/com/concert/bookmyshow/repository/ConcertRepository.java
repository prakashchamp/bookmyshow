package com.concert.bookmyshow.repository;

import com.concert.bookmyshow.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert,Long> {
}
