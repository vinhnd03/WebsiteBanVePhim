package nhom3.datn.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.ThongkeDao;
import nhom3.datn.entity.MonthlyRevenueDTO;



public interface ThongkeService {
    List<MonthlyRevenueDTO> getMonthlyRevenue();
}
