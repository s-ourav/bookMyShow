package com.example.BookMyShow.RequestDTOs;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AddMovieReq {
    private String movieName;
    private Genre genre;
    private Language language;
    private LocalDate releaseDate;
    private double  duration;
}
