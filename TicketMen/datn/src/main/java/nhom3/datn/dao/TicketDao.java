package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Long>{
    
}
