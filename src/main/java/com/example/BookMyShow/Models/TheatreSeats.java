package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;

@Entity
public class TheatreSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreSeatId;
    private String seatNo;
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theatre theatre;
}
