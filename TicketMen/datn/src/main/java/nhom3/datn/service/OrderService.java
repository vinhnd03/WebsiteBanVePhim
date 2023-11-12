package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Movie;
import nhom3.datn.entity.Order;

public interface OrderService {

    List<Order> findAll();

    Order findById(Long id);

    Order create(Order order);
    
}
