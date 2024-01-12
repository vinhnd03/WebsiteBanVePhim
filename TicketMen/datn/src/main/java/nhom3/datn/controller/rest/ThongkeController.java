package nhom3.datn.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom3.datn.dao.ThongkeDao;
import nhom3.datn.entity.MonthlyRevenueDTO;
import nhom3.datn.service.ThongkeService;


@Controller
@RequestMapping("/rest/statistic")
public class ThongkeController {
    @Autowired
    private ThongkeService revenueService;

    @GetMapping("/monthly")
public List<MonthlyRevenueDTO> getMonthlyRevenue() {
    System.out.println("Controller method getMonthlyRevenue is called.");
    return revenueService.getMonthlyRevenue();
}
}
