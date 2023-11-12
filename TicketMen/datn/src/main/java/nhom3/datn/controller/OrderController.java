package nhom3.datn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom3.datn.entity.Movie;
import nhom3.datn.service.MovieService;

@Controller
public class OrderController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/order/select/{id}")
    public String select(Model model, @PathVariable("id") Long id){
        model.addAttribute("Tid", id);
        
        return "order/select";
    }

    
    @RequestMapping("/order/bill")
    public String bill(){
        return "order/bill";
    }
}
