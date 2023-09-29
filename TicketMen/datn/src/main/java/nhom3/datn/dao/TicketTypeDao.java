package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.TicketType;

public interface TicketTypeDao extends JpaRepository<TicketType, String>{
    
}
