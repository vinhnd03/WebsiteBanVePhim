package nhom3.datn.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhom3.datn.entity.MonthlyRevenueDTO;
import nhom3.datn.service.ThongkeService;

@Service
@Transactional
public class ThongkeServiceImpl implements ThongkeService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MonthlyRevenueDTO> getMonthlyRevenue() {
        // Thực hiện các truy vấn thống kê thông qua EntityManager
         String jpqlQuery = "SELECT NEW com.example.dto.MonthlyRevenueDTO("
                + "MONTH(o.createDate), "
                + "c.name, "
                + "SUM(t.price), "
                + "SUM(CASE WHEN f.id IS NOT NULL THEN f.price ELSE 0 END)"
                + ")"
                + " FROM Orders o "
                + "JOIN OrderDetails od ON o.id = od.orderId "
                + "JOIN Tickets t ON od.ticketId = t.id "
                + "JOIN Movies m ON t.movieId = m.id "
                + "JOIN Categories c ON m.categoryId = c.id "
                + "LEFT JOIN FoodOrders fo ON o.id = fo.orderId "
                + "LEFT JOIN Foods f ON fo.foodId = f.id "
                + "GROUP BY MONTH(o.createDate), c.name";

        TypedQuery<MonthlyRevenueDTO> query = entityManager.createQuery(jpqlQuery, MonthlyRevenueDTO.class);

        return query.getResultList();
        // Ví dụ: sử dụng JPQL hoặc Native Query để lấy dữ liệu
    }
}
