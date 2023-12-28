package nhom3.datn.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom3.datn.dao.ThongkeDao;
import nhom3.datn.entity.Thongke;
import nhom3.datn.service.ThongkeDaoImpl;


@Controller
@RequestMapping("/revenue")
public class ThongkeController {
    @Autowired
    private ThongkeDao revenueService;

    @GetMapping("/monthly")
    public String getMonthlyRevenue(Model model) {
        List<Thongke> thongke = revenueService.getMonthlyRevenue();
        model.addAttribute("thongke", thongke);
        return "revenue";
    }
}
