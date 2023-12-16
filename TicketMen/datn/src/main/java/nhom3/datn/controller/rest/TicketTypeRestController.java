package nhom3.datn.controller.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import nhom3.datn.service.TicketTypeService;
=======
import nhom3.datn.service.FoodService;
>>>>>>> de434c3d02937a24032836fb7d81b8c6c83ae855



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/foods")
public class TicketTypeRestController {
    @Autowired
    FoodService foodService;

    
}
