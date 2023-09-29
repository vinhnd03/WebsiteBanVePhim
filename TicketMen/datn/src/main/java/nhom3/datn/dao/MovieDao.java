package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Long>{
    
}
