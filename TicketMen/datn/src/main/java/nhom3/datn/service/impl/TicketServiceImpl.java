package nhom3.datn.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.TicketDao;
import nhom3.datn.entity.Ticket;
import nhom3.datn.service.TicketService;

@Service 
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketDao tdao;

    @Override
    public List<Ticket> findAll() {
       return tdao.findAll();
    }

    @Override
    public Ticket findById(Long id) {
        return tdao.findById(id).get();
    }

    // @Override
    // public List<Ticket> findByTicketTypeId(String cid) {
    //     return tdao.findByTicketTypeId(cid);
    // }

    @Override
    public List<Ticket> findByRoomId(Integer rid) {
        return tdao.findByRoomId(rid);
    }
    @Override
    public Ticket create(Ticket product) {
        return tdao.save(product);
    }

    @Override
    public Ticket update(Ticket product) {
        return tdao.save(product);
    }

    @Override
    public void delete(Long id) {
        tdao.deleteById(id);
    }

    @Override
    public List<Ticket> findTicketByMovieId(Long id) {
        return tdao.findTicketByMovieId(id);
    }

    @Override
    public List<Ticket> findTicketByDateAndMovieId(Date selectedDate, Long id) {
        return tdao.findTicketsByDateAndMovieId(selectedDate, id);
    }

    @Override
    public List<Date> findTicketDateByMovieId(Long id) {
        return tdao.findTicketDateByMovieId(id);
    }

    @Override
    public List<Ticket> findShowtimeByMovieIdAndDate(Long movieId, Date date) {
        return tdao.findShowtimeByMovieIdAndDate(movieId, date);
    }

    @Override
    public Optional<Ticket> findById2(Long id) {
        return tdao.findById(id);
    }
}
