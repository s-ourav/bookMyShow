package com.example.BookMyShow.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;
    private LocalDate showDate;
    private LocalTime showTime;

    @JoinColumn
    @ManyToOne
    private Movie movie;

    @JoinColumn
    @ManyToOne
    private Theatre theatre;

    @OneToMany (mappedBy = "show", cascade = CascadeType.ALL)
    List<ShowSeats> showSeatsList=new ArrayList<>();

}
