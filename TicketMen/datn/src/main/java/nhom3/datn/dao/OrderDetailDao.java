package nhom3.datn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {
    @Query("SELECT d FROM OrderDetail d WHERE d.order.id=?1")
    List<OrderDetail> findDetailByOrderId(Long id);

    @Query("SELECT d FROM OrderDetail d WHERE d.order.id=?1 and d.ticket.id=?2")
    List<OrderDetail> findDetailByOrderId(Long id, Long tid);

    
    
}
