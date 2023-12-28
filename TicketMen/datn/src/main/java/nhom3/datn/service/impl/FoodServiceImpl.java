package nhom3.datn.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.FoodDao;
import nhom3.datn.entity.Category;
import nhom3.datn.entity.Food;
import nhom3.datn.service.FoodService;

@Service 
public class FoodServiceImpl implements FoodService{
    @Autowired
    FoodDao fdao;

    @Override
    public List<Food> findAll() {
       return fdao.findAll();
    }


    @Override
    public Food findById(Long id) {
    return fdao.findById(id).get();
    }

    @Override
    public Food create(Food food) {
        return fdao.save(food);
    }

    @Override
    public Food update(Food food) {
       return fdao.save(food);
    }

    @Override
    public void delete(Long id) {
        fdao.deleteById(id);
    }

        
}
