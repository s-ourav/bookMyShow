package com.example.BookMyShow.RequestDTOs;

import lombok.Data;

@Data
public class AddTheatreSeats {
    int noOfClassic;
    int noOfpremium;
    int theatreId;
}
