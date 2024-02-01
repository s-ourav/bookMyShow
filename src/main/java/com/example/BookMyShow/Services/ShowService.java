package com.example.BookMyShow.Services;

import com.example.BookMyShow.CustomException.InvalidMovieException;
import com.example.BookMyShow.CustomException.InvalidTheatreException;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repositories.MovieRep;
import com.example.BookMyShow.Repositories.ShowRep;
import com.example.BookMyShow.Repositories.ShowSeatsRep;
import com.example.BookMyShow.Repositories.TheatreRep;
import com.example.BookMyShow.RequestDTOs.AddShowReq;
import com.example.BookMyShow.RequestDTOs.AddShowSeatsReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRep showRep;
    @Autowired
    private MovieRep movieRep;
    @Autowired
    private TheatreRep theatreRep;
    @Autowired
    private ShowSeatsRep showSeatsRep;
    public String addShow (AddShowReq addShowReq) throws Exception {
        Movie movie=movieRep.findMovieByMovieName(addShowReq.getMovieName());
        Theatre theatre=theatreRep.findTheatreByNameAndAddress(addShowReq.getTheatreName(),addShowReq.getTheatreAddress());

        if( movie==null)
            throw new InvalidMovieException("Movie name doesn't exist") ;

        if (theatre==null)
            throw new InvalidTheatreException("Theatre name and address doesn't match or exist in table");

        Show newShow = Show.builder()
                .showDate(addShowReq.getShowDate())
                .showTime(addShowReq.getShowTime())
                .movie(movie)
                .theatre(theatre)
                .build();


        movie.getShowList().add(newShow);
        theatre.getShowList().add(newShow);

        newShow = showRep.save(newShow);

        movieRep.save(movie);
        theatreRep.save(theatre);

        return "New Show saved with show ID "+ newShow.getShowId();

    }

    public String addShowSeats (AddShowSeatsReq addShowSeatsReq) throws Exception {
        Optional <Show> optionalShowSeats=showRep.findById(addShowSeatsReq.getShowId());
        if(optionalShowSeats.isEmpty()){
            throw new Exception("Show Id doesn't exist");
        }
        Show thisShow=optionalShowSeats.get();
        Theatre theatre=thisShow.getTheatre();

        for(TheatreSeats theatreSeats : theatre.getTheatreSeatsList()){
            ShowSeats showSeats= ShowSeats.builder()
                            .seatNo(theatreSeats.getSeatNo())
                            .seatType(theatreSeats.getSeatType())
                            .isAvailable(Boolean.TRUE)
                            .foodAttached(Boolean.FALSE)
                            .show(thisShow)
                            .build();

            if(theatreSeats.getSeatType().equals(SeatType.CLASSIC)) {
                showSeats.setPrice(addShowSeatsReq.getPriceForClassicSeats());
            }
            else showSeats.setPrice(addShowSeatsReq.getPriceForPremiumSeats());

            thisShow.getShowSeatList().add(showSeats);
            showSeatsRep.save(showSeats);
        }

        return "Show seats created for show Id"+ thisShow.getShowId();

    }
}
