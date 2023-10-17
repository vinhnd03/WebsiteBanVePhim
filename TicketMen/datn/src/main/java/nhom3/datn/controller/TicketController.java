
package nhom3.datn.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nhom3.datn.entity.Ticket;
import nhom3.datn.service.TicketService;





@Controller
public class TicketController {
    @Autowired
    TicketService ticketService;

    @RequestMapping("/ticket/list")
    public String list(Model model, @RequestParam("cid") Optional<String> cid) {
        if (cid.isPresent()) {
            List<Ticket> list = ticketService.findByTicketTypeId(cid.get());
            model.addAttribute("items", list);
        } else {
            List<Ticket> list = ticketService.findAll();
            model.addAttribute("items", list);
        }
        return "ticket/list";
    }

    @RequestMapping("/ticket/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Ticket item = ticketService.findById(id);
        model.addAttribute("item", item);
        return "ticket/detail";
    }

}