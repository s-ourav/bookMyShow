package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.TheatreSeats;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatsRep extends JpaRepository<TheatreSeats,Integer > {
    TheatreSeats findTheatreSeatsBySeatNo (String seatNo);
}
