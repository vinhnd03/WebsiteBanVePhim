package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long>{
    
}
