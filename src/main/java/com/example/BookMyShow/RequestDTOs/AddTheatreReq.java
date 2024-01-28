package com.example.BookMyShow.RequestDTOs;

import lombok.Data;

@Data
public class AddTheatreReq {

    private String name;
    private String address;
    private int noOfScreens;
}
