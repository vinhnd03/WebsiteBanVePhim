package nhom3.datn.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.FoodOrder;

public interface FoodOrderDao extends JpaRepository<FoodOrder, Long>{
    
    @Query("SELECT f FROM FoodOrder f WHERE f.order.id=?1")
    List<FoodOrder>findFoodByOrderId(Long id);


    
}
