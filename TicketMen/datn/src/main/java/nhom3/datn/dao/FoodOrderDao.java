package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.FoodOrder;

public interface FoodOrderDao extends JpaRepository<FoodOrder, Long>{
    
}
