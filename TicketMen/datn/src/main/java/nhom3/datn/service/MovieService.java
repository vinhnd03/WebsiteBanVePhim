package nhom3.datn.service;



import java.util.List;


import nhom3.datn.entity.Movie;


public interface MovieService {

    List<Movie> findAll();

    Movie findById(Long id);

    List<Movie> findByCategoryId(String cid);

    Movie create(Movie movie);

    Movie update(Movie movie);

    void delete(Long id);
}
