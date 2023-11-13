package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.OrderDao;
import nhom3.datn.entity.Movie;
import nhom3.datn.entity.Order;
import nhom3.datn.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao odao;

    @Override
    public List<Order> findAll() {
        return odao.findAll();
    }

    @Override
    public Order findById(Long id) {
        return odao.findById(id).get();
    }

    @Override
    public Order create(Order order) {
        return odao.save(order);
    }
    
}
