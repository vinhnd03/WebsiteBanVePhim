package nhom3.datn.service;



import java.util.Date;
import java.util.List;


import nhom3.datn.entity.Movie;


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

   

}
