package com.example.BookMyShow.Services;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Repositories.MovieRep;
import com.example.BookMyShow.RequestDTOs.AddMovieReq;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRep movieRep ;
    public String addMovie(AddMovieReq addMovieReq){
        Movie movie=Movie.builder()
                .movieName(addMovieReq.getMovieName())
                .genre (addMovieReq.getGenre())
                .language(addMovieReq.getLanguage())
                .duration(addMovieReq.getDuration())
                .releaseDate(addMovieReq.getReleaseDate())
                .build();

        movie=movieRep.save(movie);
        return "The movie "+movie.getMovieName()+" has been added";

    }
}
