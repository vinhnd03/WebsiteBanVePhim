package nhom3.datn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.Food;
import nhom3.datn.entity.FoodOrder;

public interface FoodDao extends JpaRepository<Food, Long>{
    // @Query("SELECT f FROM Food f WHERE f.food.id=?1")
    // List<Food>findFoodById(Long id);
}
