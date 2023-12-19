package nhom3.datn.service;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import nhom3.datn.entity.Movie;
import nhom3.datn.entity.Ticket;


public interface MovieService {

    List<Movie> findAll();

    Movie findById(Long id);

    List<Movie> findByCategoryId(Integer cid);

    Movie create(Movie movie);

    Movie update(Movie movie);

    void delete(Long id);

    List<Movie> findTodayMovie();

    List<Movie> findFutureMovie();

    List<Movie> searchMoviesByNameAndCountry(String name, String country);

    List<Movie> searchMoviesByNameCountryAndCategory(String name, String country, Integer categoryId);

    List<Movie> searchMoviesByName(String name);

    List<Movie> findAllSorted();

    List<Movie> findAllAvailable();

    Optional<Movie> findById2(Long id);

    List<Movie> searchMovieWithTodayAndFutureTicket();

    List<Ticket> searchByTicketFutureMovieId(Long id);

    List<String> searchTimeByDate(String date, Long id);

    Page<Movie> findByCategoryIdPaged(Integer integer, PageRequest of);

    Page<Movie> findAllPaged(PageRequest of);



   

}
