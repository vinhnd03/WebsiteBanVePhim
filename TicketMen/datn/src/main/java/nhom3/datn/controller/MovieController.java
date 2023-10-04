package nhom3.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {
    @GetMapping("/movie/list")
    public String list(){
        return "movie/list";
    }

    @GetMapping("/movie/showtime")
    public String showtime(){
        return "movie/showtime";
    }
}
