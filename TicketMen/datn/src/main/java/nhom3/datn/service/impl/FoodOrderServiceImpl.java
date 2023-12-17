package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.FoodOrderDao;
import nhom3.datn.entity.FoodOrder;
import nhom3.datn.entity.OrderDetail;
import nhom3.datn.service.FoodOrderService;

@Service
public class FoodOrderServiceImpl implements FoodOrderService{
    @Autowired
    FoodOrderDao foDao;

    @Override
    public FoodOrder create(FoodOrder foodOrder) {
        return foDao.save(foodOrder);
    }

    @Override
    public List<FoodOrder> findFoodByOrderId(Long id) {
        return foDao.findFoodByOrderId(id);
    }

    

    
}
