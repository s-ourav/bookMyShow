package com.example.BookMyShow.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewTicketResponse {

    private String movieName;
    private String theatreName;
    private LocalDate localDate;
    private LocalTime localTime;
    private int totalAmount;
    private String seatNos;
}
