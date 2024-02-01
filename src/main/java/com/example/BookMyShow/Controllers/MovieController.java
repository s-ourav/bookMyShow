package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.RequestDTOs.AddMovieReq;
import com.example.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody AddMovieReq addMovieReq){
        return new ResponseEntity<>(movieService.addMovie(addMovieReq), HttpStatus.CREATED);
    }

}
