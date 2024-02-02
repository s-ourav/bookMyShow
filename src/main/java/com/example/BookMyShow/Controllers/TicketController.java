package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.RequestDTOs.BookAticketReq;
import com.example.BookMyShow.Responses.ViewTicketResponse;
import com.example.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket (@RequestBody BookAticketReq bookTicketReq){
        try {
            return new ResponseEntity(ticketService.bookAticket(bookTicketReq), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/viewTicket")
    public ViewTicketResponse viewTicketResponse (@RequestParam ("ticketId") int ticketId){
        try {
            return ticketService.viewTicket(ticketId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  null;
        }
    }
}
