package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Seat;

public interface SeatDao extends JpaRepository<Seat, Integer>{
    
}
