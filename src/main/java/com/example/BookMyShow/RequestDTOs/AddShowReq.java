package com.example.BookMyShow.RequestDTOs;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Models.ShowSeats;
import com.example.BookMyShow.Models.Theatre;
import com.example.BookMyShow.Models.Tickets;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class AddShowReq {
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theatreName;
    private String theatreAddress;


}
