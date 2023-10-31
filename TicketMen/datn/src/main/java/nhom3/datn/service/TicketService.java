package nhom3.datn.service;

import java.util.List;


import nhom3.datn.entity.Ticket;


public interface TicketService {

    List<Ticket> findAll();

    Ticket findById(Long id);

    Ticket create(Ticket movie);

    Ticket update(Ticket movie);

    void delete(Long id);
}
