package com.example.BookMyShow.Models;

import jakarta.persistence.*;

public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int ticketId;
    private String seatNosBooked;
    private int totalAmountPaid;

    @JoinColumn
    @ManyToOne
    private Show show;
}
