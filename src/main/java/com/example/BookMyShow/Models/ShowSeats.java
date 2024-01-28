package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;

public class ShowSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showSeatId;

    private int price;
    private boolean isAvailable;
    private boolean foodAttached;
    private int seatNo; // will come from theatre seats
    private SeatType seatType;// will come from theatre seats

    @JoinColumn
    @ManyToOne
    private Show show;

}
