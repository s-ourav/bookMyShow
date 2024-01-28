package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.Theatre;
import com.example.BookMyShow.RequestDTOs.AddTheatreReq;

public class TheatreTransformer {
    public static Theatre addTheatre (AddTheatreReq addTheatreReq){
        Theatre newTheatre = Theatre.builder()
                .name(addTheatreReq.getName())
                .address(addTheatreReq.getAddress())
                .noOfScreens(addTheatreReq.getNoOfScreens())
                .build();
        return newTheatre;
    }
}
