package com.example.BookMyShow.Services;

import com.example.BookMyShow.CustomException.SeatNotAvailableException;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.ShowSeats;
import com.example.BookMyShow.Models.TheatreSeats;
import com.example.BookMyShow.Models.Tickets;
import com.example.BookMyShow.Repositories.ShowRep;
import com.example.BookMyShow.Repositories.ShowSeatsRep;
import com.example.BookMyShow.Repositories.TheatreSeatsRep;
import com.example.BookMyShow.Repositories.TicketRep;
import com.example.BookMyShow.RequestDTOs.BookAticketReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRep ticketRep;
    @Autowired
    private ShowRep showRep;
    @Autowired
    private TheatreSeatsRep theatreSeatsRep;
    @Autowired
    private ShowSeatsRep showSeatsRep;
    public String bookAticket (BookAticketReq bookAticketReq) throws Exception{ // changes in showSeat and show:List<Tickets>

        //1. Find the show in which user is trying to book a ticket -- from DTO-showId
        //2. User has given a List <String> seatNos
        //3. So for all these seatNos check corresponding ShowSeats
        //4. if not available throw exception
        //5. else make that seat unavailable
        //6. fetch its price
        //9. if all seats available then create one ticket - with total price and string of all seatNos
        //10. add ticket to show's TicketList

        Optional <Show> optionalShow = showRep.findById(bookAticketReq.getShowId());
        if(optionalShow.isEmpty()){
            throw new Exception("Invalid show ID");
        }

        Show thisshow=optionalShow.get();


        int totalprice=0;

        for(String seatNo : bookAticketReq.getSeatList()){ //traversing seatNos chosen by User
            for(ShowSeats showSeats: thisshow.getShowSeatList()){ // traversing show's showSeatList
                if(showSeats.getSeatNo().equals(seatNo)){ //if found a match
                    if(showSeats.isAvailable()){
                            showSeats.setAvailable(Boolean.FALSE);
                            totalprice+= showSeats.getPrice();
                    }
                    else{
                        throw new SeatNotAvailableException("Seat not available");
                    }
                }
            }
        }

        Tickets ticket = Tickets.builder()
                .seatNosBooked(bookAticketReq.getSeatList().toString())
                .totalAmountPaid(totalprice)
                .show(thisshow)
                .build();

        thisshow.getTicketList().add(ticket);
        showRep.save(thisshow);

        return "Ticket saved with ticket ID "+ ticket.getTicketId()+" seat Nos :"+ticket.getSeatNosBooked()+" total amount "+ticket.getTotalAmountPaid();
    }

}
