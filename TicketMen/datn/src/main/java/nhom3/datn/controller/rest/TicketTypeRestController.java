package nhom3.datn.controller.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.service.FoodService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/foods")
public class TicketTypeRestController {
    @Autowired
    FoodService foodService;

    
}
