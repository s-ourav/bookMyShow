package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TheatreRep extends JpaRepository<Theatre,String> {
}
