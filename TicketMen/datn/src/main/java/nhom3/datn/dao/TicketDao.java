package nhom3.datn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Long>{
    // @Query("SELECT m FROM Ticket m WHERE m.ticketType.id=?1")
    // List<Ticket> findByTicketTypeId(String cid);

    @Query("SELECT m FROM Ticket m WHERE m.room.id=?1")
    List<Ticket> findByRoomId(Integer rid);
}
