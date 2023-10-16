package nhom3.datn.controller;

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
import nhom3.datn.service.MovieService;

@Controller
public class MovieController {
    @GetMapping("/movie/showtime")
    public String showtime(){
        return "movie/showtime";
    }

    @Autowired
    MovieService movieService;

    @RequestMapping("/movie/list")
    public String list(Model model, @RequestParam("cid") Optional<String> cid) {
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
        Movie item = movieService.findById(id);
        model.addAttribute("item", item);
        return "product/detail";
    }
}
