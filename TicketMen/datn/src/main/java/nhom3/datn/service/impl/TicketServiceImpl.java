package nhom3.datn.service.impl;


import java.util.List;

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
    public List<String> findTimesByDateAndMovieId(String date, Long id) {
        return tdao.findTimesByDateAndMovieId(date, id);
    }
}
