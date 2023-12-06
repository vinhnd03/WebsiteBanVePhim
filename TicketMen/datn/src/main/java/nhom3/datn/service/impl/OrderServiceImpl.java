package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.OrderDao;
import nhom3.datn.entity.Order;
import nhom3.datn.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao dao;

    @Override
    public Order findById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }

    @Override
    public Order create(Order order) {
        return dao.save(order);
    }

    @Override
    public List<Order> findByUsername(String username) {
        return dao.findByUsername(username);
    }

    
}
