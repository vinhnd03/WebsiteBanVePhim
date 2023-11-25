package nhom3.datn.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);

        // Lấy danh sách ID phim
        List<Long> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        System.out.println(movieIds);

        model.addAttribute("movieIds", movieIds);

        // Thêm danh sách vé cho từng phim vào model
        Map<Long, List<String>> ticketsByMovieId = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Long movieId : movieIds) {
            List<Date> dates = ticketService.findTicketDateByMovieId(movieId);
            List<String> formattedDates = dates.stream()
                    .map(date -> dateFormat.format(date))
                    .collect(Collectors.toList());
            ticketsByMovieId.put(movieId, formattedDates);
        }

        model.addAttribute("ticketsByMovieId", ticketsByMovieId);

        

        return "showtime/list";
    }
}
