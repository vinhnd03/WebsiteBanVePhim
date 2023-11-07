package nhom3.datn.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nhom3.datn.entity.Ticket;


public interface TicketDao extends JpaRepository<Ticket, Long>{
    // @Query("SELECT m FROM Ticket m WHERE m.ticketType.id=?1")
    // List<Ticket> findByTicketTypeId(String cid);

    @Query("SELECT m FROM Ticket m WHERE m.room.id=?1")
    List<Ticket> findByRoomId(Integer rid);

     @Query("SELECT t.time FROM Ticket t " +
           "JOIN t.movie m " +
           "WHERE t.date = :selectedDate " +
           "AND t.date > CURRENT_DATE " +
           "AND m.id = :selectedMovieId")
    List<String> findTimesByDateAndMovieId(
        @Param("selectedDate") String date,
        @Param("selectedMovieId") Long movieId);
}
