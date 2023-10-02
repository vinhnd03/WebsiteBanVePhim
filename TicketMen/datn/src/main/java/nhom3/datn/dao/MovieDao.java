package nhom3.datn.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Long>{
    @Query("SELECT p FROM Movie p WHERE p.category.id=?1")
    List<Movie> findByCategoryId(String cid);
}
