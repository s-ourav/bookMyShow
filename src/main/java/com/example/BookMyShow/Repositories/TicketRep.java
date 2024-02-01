package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRep extends JpaRepository<Tickets,Integer> {
}
