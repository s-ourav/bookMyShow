package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRep extends JpaRepository<Show,Integer> {

}
