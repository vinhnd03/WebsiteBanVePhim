package nhom3.datn.controller.rest;

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
            @PathVariable("date") String date,
            @PathVariable("time") @DateTimeFormat(pattern = "HH:mm:ss") Date time,
            @PathVariable("tid") Long tid) {
        return seatService.findByDateTimeAndTicketId(date, time, tid);
    }

    //  @DateTimeFormat(pattern = "dd-MM-yyyy")
}
