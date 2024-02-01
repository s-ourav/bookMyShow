package com.example.BookMyShow.RequestDTOs;

import lombok.Data;

import java.util.List;

@Data
public class BookAticketReq {

    private int showId;
    private List <String> seatList;

}
