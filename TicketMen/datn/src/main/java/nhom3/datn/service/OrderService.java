package nhom3.datn.service;

import java.util.List;
import java.util.Optional;

import nhom3.datn.entity.Order;

public interface OrderService {

    Order findById(Long id);

    List<Order> findAll();

    Order create(Order order);

    List<Order> findByUsername(String username);

    void delete(Long id);

    Optional<Order> findOrder(Long id);
 
}
