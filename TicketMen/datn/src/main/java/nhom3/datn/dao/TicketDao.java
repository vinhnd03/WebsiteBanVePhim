package nhom3.datn.dao;

import java.text.SimpleDateFormat;
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


     @Query("SELECT t FROM Ticket t " +
           "JOIN t.movie m " +
           "WHERE t.date = :selectedDate " +
        //    "AND t.date > GETDATE() " +
           "AND m.id = :selectedMovieId " + 
           "ORDER BY t.time ASC")
    List<Ticket> findTicketsByDateAndMovieId(
        @Param("selectedDate") Date selectedDate,
        @Param("selectedMovieId") Long movieId);


    @Query("SELECT DISTINCT t FROM Ticket t WHERE t.movie.id = ?1")
    List<Ticket> findTicketByMovieId(Long id);

    @Query("SELECT t.date FROM Ticket t WHERE t.movie.id = ?1 AND CONVERT(DATE, t.date) >= CONVERT(DATE, CURRENT_TIMESTAMP) ORDER BY t.date ASC ")
    List<Date> findTicketDateByMovieId(Long id);

    @Query("SELECT t FROM Ticket t WHERE t.movie.id = :movieId AND t.date = :date  ORDER BY t.time ASC")
    List<Ticket> findShowtimeByMovieIdAndDate(@Param("movieId") Long id,  @Param("date") Date date);

}
