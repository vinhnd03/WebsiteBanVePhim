package nhom3.datn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import nhom3.datn.entity.Movie;
import nhom3.datn.service.MovieService;


@Controller
public class HomeController {
    @Autowired
    MovieService movieService;

    @RequestMapping({"/home/index","/"})
    public String home(Model model){
        List<Movie> list = movieService.findAll();
        model.addAttribute("items", list);
        return "layout/home";
    }

        @RequestMapping({"/admin", "/admin/home/index"})
    public String admin(){
        return "redirect:/admin/index2.html";
    }

    @RequestMapping("/qna")
    public String qna(){
        return "other/qna";
    }

    @RequestMapping("/discount")
    public String discount(){
        return "other/discount";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "other/contact";
    }

    @RequestMapping("/service")
    public String service(){
        return "other/service";
    }

}

