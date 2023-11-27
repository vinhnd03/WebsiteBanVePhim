package nhom3.datn.service;

import java.util.Date;
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

    List<Ticket> findTicketByMovieId(Long id);

    List<Ticket> findTicketByDateAndMovieId(Date selectedDate, Long id);

    List<Date> findTicketDateByMovieId(Long id);

    List<Ticket> findShowtimeByMovieIdAndDate(Long movieId, Date date);
}
