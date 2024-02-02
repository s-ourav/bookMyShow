package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User,Integer> {
    User findByEmailId(String emailId);
}
