package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRep extends JpaRepository<Movie,String> {
}
