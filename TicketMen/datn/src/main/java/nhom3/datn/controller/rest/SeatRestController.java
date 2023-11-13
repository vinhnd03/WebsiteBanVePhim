package nhom3.datn.controller.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Room;
import nhom3.datn.entity.Seat;
import nhom3.datn.service.SeatService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/seats")
public class SeatRestController {
    @Autowired
    SeatService seatService;

    @GetMapping("{id}")
    public Seat getOne(@PathVariable("id") Integer id) {
        return seatService.findById(id);
    }

    @GetMapping()
    public List<Seat> getAll() {
        return seatService.findAll();
    }

    @GetMapping("/name/{name}")
    public Seat getByName(@PathVariable("name") String name) {
        return seatService.findByName(name);
    }

    @GetMapping("/byDateTimeAndTId/{date}/{time}/{tid}")
    public List<Seat> getByDateTimeAndTicketId(
            @PathVariable("date") String dateString,
            @PathVariable("time")  String timeString,
            @PathVariable("tid") Long tid) {
        
        try{
            Date date = new SimpleDateFormat("MM-dd-yyyy").parse(dateString);
            Date time = new SimpleDateFormat("HH:mm:ss").parse(timeString);
            
            return seatService.findByDateTimeAndTicketId(date, time, tid);          
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

        
    }

    //  @DateTimeFormat(pattern = "dd-MM-yyyy")
}
