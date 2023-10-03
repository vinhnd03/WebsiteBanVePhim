package nhom3.datn.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.MovieDao;
import nhom3.datn.entity.Movie;
import nhom3.datn.service.ProductService;

@Service 
public class ProductServiceImpl implements ProductService{
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
    public List<Movie> findByCategoryId(String cid) {
        return mdao.findByCategoryId(cid);
    }

    @Override
    public Movie create(Movie product) {
        return mdao.save(product);
    }

    @Override
    public Movie update(Movie movie) {
        return mdao.save(movie);
    }

    @Override
    public void delete(Long id) {
        mdao.deleteById(id);
    }
}
