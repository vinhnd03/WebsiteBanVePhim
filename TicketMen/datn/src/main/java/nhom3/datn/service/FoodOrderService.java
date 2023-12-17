package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.FoodOrder;
import nhom3.datn.entity.OrderDetail;

public interface FoodOrderService {

    FoodOrder create(FoodOrder foodOrder);

    List<FoodOrder> findFoodByOrderId(Long id);

    
    
}
