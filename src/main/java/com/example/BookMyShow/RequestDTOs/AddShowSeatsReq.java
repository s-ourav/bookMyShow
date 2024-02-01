package com.example.BookMyShow.RequestDTOs;

import lombok.Data;

@Data
public class AddShowSeatsReq {
    private int priceForPremiumSeats;
    private int priceForClassicSeats;
    private int showId;
}
