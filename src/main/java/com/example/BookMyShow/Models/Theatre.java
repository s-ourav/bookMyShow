package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private String  theatreId;
    private String name;
    private String address;
    private int noOfScreens;

    @OneToMany (mappedBy = "theatre",cascade = CascadeType.ALL )
    List<TheatreSeats> theatreSeatsList=new ArrayList<>();

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL )
    List<Show> showList= new ArrayList<>();
}
