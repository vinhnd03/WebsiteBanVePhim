package nhom3.datn.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Long>{
    @Query("SELECT m FROM Movie m WHERE m.category.id=?1")
    List<Movie> findByCategoryId(Integer cid);


    @Query("SELECT DISTINCT M FROM Movie M " +
           "INNER JOIN Ticket T ON M.id = T.movie.id " +
           "WHERE CONVERT(DATE, T.date) = CONVERT(DATE, CURRENT_TIMESTAMP)")
    List<Movie> findTodayMovie();

    @Query("SELECT DISTINCT M FROM Movie M " +
           "INNER JOIN Ticket T ON M.id = T.movie.id " +
           "WHERE CONVERT(DATE, T.date) BETWEEN DATEADD(DAY, 1, CONVERT(DATE, CURRENT_TIMESTAMP)) " +
           "AND DATEADD(DAY, 6, CONVERT(DATE, CURRENT_TIMESTAMP))")
    List<Movie> findFutureMovie();
}
