package com.example.BookMyShow.Services;

import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.Theatre;
import com.example.BookMyShow.Models.TheatreSeats;
import com.example.BookMyShow.Repositories.TheatreRep;
import com.example.BookMyShow.Repositories.TheatreSeatsRep;
import com.example.BookMyShow.RequestDTOs.AddTheatreReq;
import com.example.BookMyShow.RequestDTOs.AddTheatreSeatsReq;
import com.example.BookMyShow.Transformers.TheatreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {
    @Autowired
    private TheatreRep theatreRep;
    @Autowired
    private TheatreSeatsRep theatreSeatsRep;

    public String addTheatre(AddTheatreReq addTheatreReq){
        Theatre newTheatre = TheatreTransformer.addTheatre(addTheatreReq);
        newTheatre= theatreRep.save(newTheatre);
        return "The theatre "+ newTheatre.getTheatreId()+" is saved";
    }
    public String addTheatreSeats (AddTheatreSeatsReq addTheatreSeatsReq) {
        int noOfClassic= addTheatreSeatsReq.getNoOfClassic();
        int noOfPremium= addTheatreSeatsReq.getNoOfpremium();
        int theatreId= addTheatreSeatsReq.getTheatreId();
        Optional <Theatre> optionalTheatre =theatreRep.findById(theatreId);
        if(!optionalTheatre.isPresent())
            return "Invalid theatreId";

        Theatre theatre=optionalTheatre.get();
        List<TheatreSeats> theatreSeatsList=new ArrayList<>();
        int num=1;char ch='A';
        while(noOfClassic-->0){
            TheatreSeats theatreSeats=new TheatreSeats(num+""+ch, SeatType.CLASSIC,theatre);
            theatreSeatsList.add(theatreSeats);
            theatreSeatsRep.save(theatreSeats);
            ch++;
            if(ch>'E'){
                num++;ch='A';
            }
        }

        num++;
        ch='A';

        while(noOfPremium-->0){
            TheatreSeats theatreSeats=new TheatreSeats(num+""+ch, SeatType.PREMIUM,theatre);
            theatreSeatsList.add(theatreSeats);
            theatreSeatsRep.save(theatreSeats);
            ch++;
            if(ch>'E'){
                num++;ch='A';
            }
        }
        theatre.setTheatreSeatsList(theatreSeatsList);
        theatreRep.save(theatre);
        return "Theatre seats have been added";
    }

}
