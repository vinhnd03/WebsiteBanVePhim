package nhom3.datn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.SeatDao;
import nhom3.datn.entity.Seat;
import nhom3.datn.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    SeatDao seatDao;

    @Override
    public Seat findById(Integer id) {
        return seatDao.findById(id).get();
    }

    @Override
    public List<Seat> findAll() {
        return seatDao.findAll();
    }

    @Override
    public Seat findByName(String name) {
        return seatDao.findByName(name);
    }

    @Override
    public List<Seat> findByDateTimeAndTicketId(String date, Date time, Long tid) {
        return seatDao.findSeatsByDateAndTimeAndTicketId(date, time, tid);
    }

    
}
