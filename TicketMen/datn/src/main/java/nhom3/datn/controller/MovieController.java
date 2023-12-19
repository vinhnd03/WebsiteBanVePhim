package nhom3.datn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public String list(Model model, @RequestParam("cid") Optional<Integer> cid,
    @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
		int pageSize = size.orElse(12);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
		Page<Movie> resultPage = null;

		
		resultPage = movieService.findAll(pageable);
		
		int totalPages = resultPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currentPage - 2) ;
			int end = Math.min(currentPage + 2, totalPages);

			if (totalPages > 5) {
				if (end == totalPages)
					start = end - 5;
				else if (start == 1)
					end = start + 5;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed().collect(Collectors.toList());
			
			model.addAttribute("pageNumbers", pageNumbers);
		}

		model.addAttribute("moviePage", resultPage);
        
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
            Optional<Movie> item = movieService.findById2(id);
            if (!item.isPresent()) {
                return "redirect:/";
            }
            List<Ticket> showtimes = ticketService.findTicketByDateAndMovieId(selectedDate, id);
            model.addAttribute("item", item.get());
            model.addAttribute("showtime", showtimes);
        } catch (ParseException e) {
            // Xử lý lỗi nếu có lỗi khi chuyển đổi định dạng
            e.printStackTrace();
        }

        return "movie/detail";
    }
    // @GetMapping("/movie/search")
    // public String searchMovies(Model model, @RequestParam(value = "name",
    // required = false) String name,
    // @RequestParam(value = "country", required = false) String country,
    // @RequestParam(value = "categoryId", required = false) Integer categoryId) {
    // if (name != null && country != null && categoryId != null) {
    // // Tìm kiếm theo tên, quốc gia và ID danh mục
    // List<Movie> movies = movieService.searchMoviesByNameCountryAndCategory(name,
    // country, categoryId);
    // model.addAttribute("movies", movies);
    // } else if (name != null && country != null) {
    // // Tìm kiếm theo tên và quốc gia
    // List<Movie> movies = movieService.searchMoviesByNameAndCountry(name,
    // country);
    // model.addAttribute("movies", movies);
    // } else if (name != null) {
    // // Tìm kiếm theo tên
    // List<Movie> movies = movieService.searchMoviesByNameAndCountry(name,
    // country);
    // model.addAttribute("movies", movies);
    // } else {
    // // Hiển thị form tìm kiếm nếu không có thông tin tìm kiếm được cung cấp
    // return "movie/search";
    // }
    // return "movie/list";
    // }
}
