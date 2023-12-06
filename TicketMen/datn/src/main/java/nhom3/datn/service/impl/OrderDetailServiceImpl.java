package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.OrderDetailDao;
import nhom3.datn.entity.OrderDetail;
import nhom3.datn.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailDao odao;

    @Override
    public List<OrderDetail> findAll() {
        return odao.findAll();
    }

    @Override
    public OrderDetail findById(Long id) {
        return odao.findById(id).get();
    }

    @Override
    public OrderDetail create(OrderDetail order) {
        return odao.save(order);
    }

    @Override
    public List<OrderDetail> findDetailByOrderId(Long id) {
        return odao.findDetailByOrderId(id);
    }

    @Override
    public List<OrderDetail> findDetailByOrderId(Long id, Long tid) {
        return odao.findDetailByOrderId(id , tid);
    }
    
}
