package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.RequestDTOs.AddShowReq;
import com.example.BookMyShow.RequestDTOs.AddShowSeatsReq;
import com.example.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody AddShowReq addShowReq){
        try {
            return new ResponseEntity(showService.addShow(addShowReq), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addShowSeats")
    public ResponseEntity addShowSeats (@RequestBody AddShowSeatsReq addShowSeatsReq){
        try {
            return new ResponseEntity(showService.addShowSeats(addShowSeatsReq),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/getShow")
//    public ResponseEntity getShow () {
//
//    }
}
