package nhom3.datn.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom3.datn.entity.Movie;
import nhom3.datn.entity.Ticket;
import nhom3.datn.service.MovieService;
import nhom3.datn.service.TicketService;

@Controller
public class ShowtimeController {
    @Autowired
    MovieService movieService;

    @Autowired
    TicketService ticketService;

    @RequestMapping("/showtime")
    public String list(Model model) {
        List<Movie> movies = movieService.findAllAvailable();
        model.addAttribute("movies", movies);

        List<Long> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        model.addAttribute("movieIds", movieIds);

        Map<Long, Map<String, List<Ticket>>> showtimesByMovieId = new HashMap<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Long movieId : movieIds) {
            List<Date> dates = ticketService.findTicketDateByMovieId(movieId);
            
            System.out.println("date: " + dates);

            Collections.sort(dates);

            Map<String, List<Ticket>> showtimesByDate = new HashMap<>();

            for (Date date : dates) {
                
                List<Ticket> showtimes = ticketService.findShowtimeByMovieIdAndDate(movieId, date);
                
                showtimesByDate.put(dateFormat.format(date), showtimes);
                // showtimesByDate.put(date, showtimes);

            }
            
            showtimesByMovieId.put(movieId, showtimesByDate);
            // System.out.println("showtime: " + showtimesByMovieId);
        }

        model.addAttribute("showtimesByMovieId", showtimesByMovieId);

        return "showtime/list";
    }

}
