package nhom3.datn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom3.datn.entity.Movie;
import nhom3.datn.entity.Ticket;
import nhom3.datn.service.MovieService;
import nhom3.datn.service.TicketService;

@Controller
public class OrderController {
    @Autowired
    MovieService movieService;

    @Autowired
    TicketService ticketService;

    @GetMapping("/order/select/{id}")
    public String select(Model model, @PathVariable("id") Long id){

        Optional<Ticket> item = ticketService.findById2(id);
        if(!item.isPresent()){
            return "redirect:/";
        }
        model.addAttribute("Tid", id);        
        return "order/select";
    }

    
    @GetMapping("/order/bill/{id}")
    public String bill(Model model, @PathVariable("id") Long id){
        Optional<Ticket> item = ticketService.findById2(id);
        if(!item.isPresent()){
            return "redirect:/";
        }
        model.addAttribute("Tid", id);  
        return "order/bill";
    }
}
