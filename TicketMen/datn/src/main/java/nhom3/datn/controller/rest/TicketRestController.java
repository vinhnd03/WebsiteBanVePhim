package nhom3.datn.controller.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Ticket;
import nhom3.datn.service.TicketService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/tickets")
public class TicketRestController {
    @Autowired
    TicketService ticketService;

    @GetMapping("{id}")
    public Ticket getOne(@PathVariable("id") Long id){
        return ticketService.findById(id);
    }

    @GetMapping()
    public List<Ticket> getAll(){
        return ticketService.findAll();
    }

    @PostMapping()
    public Ticket create(@RequestBody Ticket ticket){
        return ticketService.create(ticket);
    }

    @PutMapping("{id}")
    public Ticket update(@PathVariable("id") Long id,
        @RequestBody Ticket ticket){
        return ticketService.update(ticket);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        ticketService.delete(id);
    }

    // @GetMapping("{date}/{id}")
    // public List<String> getShowtime(@PathVariable("date") String date,
    //                 @PathVariable("id") Long id){
    //     return ticketService.findTimesByDateAndMovieId(date, id);
    // }

    @GetMapping("getTicketByMovie/{movieId}")
    public List<Ticket> getTicketByMovie(@PathVariable("movieId") Long id){
        return ticketService.findTicketByMovieId(id);
    }

    @GetMapping("findTicketByMovieAndDate/{movieId}/{date}")
    public List<Ticket> findTicketByMovieAndDate(@PathVariable("movieId") Long id, @PathVariable("date") String dateString){

        try{
            Date date = new SimpleDateFormat("MM-dd-yyyy").parse(dateString);
            
            return ticketService.findTicketByDateAndMovieId(date, id);         
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
        
    }
}
