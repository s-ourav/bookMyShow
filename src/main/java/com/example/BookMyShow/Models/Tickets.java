package com.example.BookMyShow.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tickets_info")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private String seatNosBooked;
    private int totalAmountPaid;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Show show;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private User user;
}
