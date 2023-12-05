package nhom3.datn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long>{
    
    @Query("SELECT o FROM Order o Order by o.buyDate desc")
    List<Order> findAll();

    @Query("SELECT o FROM Order o WHERE o.account.username=:username")
    List<Order> findByUsername(String username);
}
