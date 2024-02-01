package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "show_seats")

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showSeatId;

    private int price;
    private boolean isAvailable;
    private boolean foodAttached;
    private String seatNo; // will come from theatre seats
    @Enumerated (value =EnumType.STRING)
    private SeatType seatType;// will come from theatre seats

    @JoinColumn
    @ManyToOne
    private Show show;

}
