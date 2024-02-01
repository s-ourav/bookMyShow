package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRep extends JpaRepository<Movie,Integer> {
    Movie findMovieByMovieName (String movieName);

}
