package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.RequestDTOs.AddTheatreReq;
import com.example.BookMyShow.RequestDTOs.AddTheatreSeatsReq;
import com.example.BookMyShow.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/Theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;
    @PostMapping("/addTheatre")
    public ResponseEntity addTheatre (@RequestBody AddTheatreReq addTheatreReq){
        return new ResponseEntity(theatreService.addTheatre((addTheatreReq)), HttpStatus.CREATED);

    }

    @PostMapping ("/addTheatreSeats")
    public ResponseEntity addTheatreSeats (@RequestBody AddTheatreSeatsReq addTheatreSeatsReq){
        return new ResponseEntity(theatreService.addTheatreSeats(addTheatreSeatsReq),HttpStatus.CREATED);
    }
}
