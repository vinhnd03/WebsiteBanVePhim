package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Category;
import nhom3.datn.entity.Food;


public interface FoodService {

    List<Food> findAll();

    Food findById(Long id);

    Food create(Food food);

    Food update(Food food);

    void delete(Long id);
}
