package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Ticket;


public interface TicketService {

    List<Ticket> findAll();

    Ticket findById(Long id);

    // List<Ticket> findByTicketTypeId(String cid);

    List<Ticket> findByRoomId(Integer rid);
    
    Ticket create(Ticket movie);

    Ticket update(Ticket movie);

    void delete(Long id);

    List<String> findTimesByDateAndMovieId(String date, Long id);
}
