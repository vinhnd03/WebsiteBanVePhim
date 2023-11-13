package nhom3.datn.service;

import java.util.Date;
import java.util.List;

import nhom3.datn.entity.Room;
import nhom3.datn.entity.Seat;

public interface SeatService {

    Seat findById(Integer id);

    List<Seat> findAll();

    Seat findByName(String name);

    List<Seat> findByDateTimeAndTicketId(String date, Date time, Long tid);
    
}
