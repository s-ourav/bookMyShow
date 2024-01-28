package com.example.BookMyShow.Services;

import com.example.BookMyShow.Models.Theatre;
import com.example.BookMyShow.Repositories.TheatreRep;
import com.example.BookMyShow.RequestDTOs.AddTheatreReq;
import com.example.BookMyShow.Transformers.TheatreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TheatreService {
    @Autowired
    private TheatreRep theatreRep;

    public String addTheatre(AddTheatreReq addTheatreReq){
        Theatre newTheatre = TheatreTransformer.addTheatre(addTheatreReq);
        theatreRep.save(newTheatre);
        return "The theatre "+ newTheatre.getName()+" is saved";
    }

}
