package com.example.BookMyShow.RequestDTOs;

import lombok.Data;

@Data
public class AddTheatreSeatsReq {
    int noOfClassic;
    int noOfpremium;
    int theatreId;
}
