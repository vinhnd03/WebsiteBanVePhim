package nhom3.datn.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Order;
import nhom3.datn.service.ResetPasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/mail")
public class SendEmailRestController {
    @Autowired
    ResetPasswordService authenService;

    @GetMapping("sendOrder")
    public void sendEmail(@RequestParam("Email") String param, @RequestParam("Order") Order order) {
        
    }
    
}
