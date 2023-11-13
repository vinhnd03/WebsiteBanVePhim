package nhom3.datn.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nhom3.datn.entity.Seat;

public interface SeatDao extends JpaRepository<Seat, Integer>{

    Seat findByName(String name);
    
    @Query("SELECT B FROM Order A " +
           "INNER JOIN Seat B ON B.id = A.seat.id " +
           "INNER JOIN Ticket C ON A.ticket.id = C.id " +
           "WHERE C.date = :dateParam AND C.time = :timeParam AND C.id = :ticketIdParam")
    List<Seat> findSeatsByDateAndTimeAndTicketId(@Param("dateParam") String date,
                                                 @Param("timeParam") Date time,
                                                 @Param("ticketIdParam") Long ticketId);
}
