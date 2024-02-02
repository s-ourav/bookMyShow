package com.example.BookMyShow.RequestDTOs;

import lombok.Data;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.util.List;

@Data
public class BookAticketReq {

    private int showId;
    private List <String> seatList;
    public String userEmailid;

}
