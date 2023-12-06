package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.MovieDao;
import nhom3.datn.entity.Movie;
import nhom3.datn.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDao mdao;

    @Override
    public List<Movie> findAll() {
        return mdao.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return mdao.findById(id).get();
    }

    @Override
    public List<Movie> findByCategoryId(Integer cid) {
        return mdao.findByCategoryId(cid);
    }

    @Override
    public Movie create(Movie product) {
        return mdao.save(product);
    }

    @Override
    public Movie update(Movie product) {
        return mdao.save(product);
    }

    @Override
    public void delete(Long id) {
        mdao.deleteById(id);
    }

    @Override
    public List<Movie> findTodayMovie() {
        return mdao.findTodayMovie();
    }

    @Override
    public List<Movie> findFutureMovie() {
        return mdao.findFutureMovie();
    }

    @Override
    public List<Movie> searchMoviesByNameAndCountry(String name, String country) {
        return mdao.findByNameAndCountry(name, country);
    }

    @Override
    public List<Movie> searchMoviesByNameCountryAndCategory(String name, String country, Integer categoryId) {
        return mdao.findByNameAndCountryAndCategoryId(name, country, categoryId);
    }

    @Override
    public List<Movie> searchMoviesByName(String name) {
       return mdao.findByName(name);
       
    }

   


}
