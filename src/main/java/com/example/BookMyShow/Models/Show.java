package com.example.BookMyShow.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "shows")

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    private LocalDate showDate;
    @Column(unique = true)
    private LocalTime showTime;

    @JsonIgnore
    @JoinColumn
    @ManyToOne
    private Theatre theatre;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Movie movie;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeats> showSeatList = new ArrayList<>();

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Tickets> ticketList = new ArrayList<>();
}
