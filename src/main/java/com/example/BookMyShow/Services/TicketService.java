package com.example.BookMyShow.Services;

import com.example.BookMyShow.CustomException.SeatNotAvailableException;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.ShowSeats;
import com.example.BookMyShow.Models.Tickets;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repositories.*;
import com.example.BookMyShow.RequestDTOs.BookAticketReq;
import com.example.BookMyShow.Responses.ViewTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
    @Autowired
    private UserRep userRep;

    @Autowired
    JavaMailSender javaMailSender;
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

        User thisuser= userRep.findByEmailId(bookAticketReq.getUserEmailid());


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
                .user(thisuser)
                .show(thisshow)
                .build();

        thisshow.getTicketList().add(ticket);
        thisuser.getTicketsList().add(ticket);
//        userRep.save(thisuser);
//        showRep.save(thisshow);
        ticketRep.save(ticket);

        String emailId= thisuser.getEmailId();
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("backendspring3@gmail.com");
        simpleMailMessage.setTo(emailId);
        simpleMailMessage.setSubject("Congrats! Movie ticket booked");
        simpleMailMessage.setText("Congrats ! You have successfully booked Ticket with ticket ID "+ ticket.getTicketId()+" seat Nos :"+ticket.getSeatNosBooked()+" total amount "+ticket.getTotalAmountPaid()+" for movie "+ thisshow.getMovie().getMovieName());
        javaMailSender.send(simpleMailMessage);
        return "Ticket saved with ticket ID "+ ticket.getTicketId()+" seat Nos :"+ticket.getSeatNosBooked()+" total amount "+ticket.getTotalAmountPaid();
    }

    public ViewTicketResponse viewTicket (int ticketId) throws Exception{
        Optional<Tickets> optionalTicket= ticketRep.findById(ticketId);
        if(optionalTicket.isEmpty()){
            throw new Exception("Invalid ticket Id");
        }

        Tickets ticket=optionalTicket.get();
        Show show=ticket.getShow();

        ViewTicketResponse viewTicketResponse= ViewTicketResponse.builder()
                .movieName(show.getMovie().getMovieName())
                .localDate(show.getShowDate())
                .localTime(show.getShowTime())
                .seatNos(ticket.getSeatNosBooked())
                .theatreName(show.getTheatre().getName())
                .totalAmount(ticket.getTotalAmountPaid())
                .build();

        return viewTicketResponse;
    }

}
