package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Food;

public interface FoodDao extends JpaRepository<Food, Long>{
    
}
