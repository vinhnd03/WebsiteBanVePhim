package nhom3.datn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nhom3.datn.entity.Movie;
import nhom3.datn.entity.Ticket;
import nhom3.datn.service.MovieService;
import nhom3.datn.service.TicketService;

@Controller
public class MovieController {
    @GetMapping("/movie/showtime")
    public String showtime() {
        return "movie/showtime";
    }

    @Autowired
    MovieService movieService;

    @Autowired
    TicketService ticketService;

    @RequestMapping("/movie/list")
    public String list(Model model, @RequestParam("cid") Optional<Integer> cid) {
        if (cid.isPresent()) {
            List<Movie> list = movieService.findByCategoryId(cid.get());
            model.addAttribute("items", list);
        } else {
            List<Movie> list = movieService.findAll();
            model.addAttribute("items", list);
        }
        return "movie/list";
    }

    @RequestMapping("/movie/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String today = dateFormat.format(date);
    try {
        Date selectedDate = dateFormat.parse(today);
        // Sử dụng selectedDate trong phần còn lại của mã
        Movie item = movieService.findById(id);
        List<Ticket> showtimes = ticketService.findTicketByDateAndMovieId(selectedDate, id);
        model.addAttribute("item", item);
        model.addAttribute("showtime", showtimes);
    } catch (ParseException e) {
        // Xử lý lỗi nếu có lỗi khi chuyển đổi định dạng
        e.printStackTrace();
    }
    
    return "movie/detail";
    }
}
