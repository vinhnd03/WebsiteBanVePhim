package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Order;

public interface OrderService {

    Order findById(Long id);

    List<Order> findAll();

    Order create(Order order);
 
}
