package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theatre_seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheatreSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreSeatId;
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theatre theatre;

    public TheatreSeats(String seatNo, SeatType seatType, Theatre theatre) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.theatre = theatre;
    }
}
