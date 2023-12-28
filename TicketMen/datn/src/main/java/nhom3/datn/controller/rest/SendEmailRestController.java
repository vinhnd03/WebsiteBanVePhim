package nhom3.datn.controller.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Order;
import nhom3.datn.service.ResetPasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/mail")
public class SendEmailRestController {
    @Autowired
    ResetPasswordService authenService;

    @PostMapping("sendOrderDetail")
    public void sendEmail(@RequestBody Map<String, Object> requestData) {
        Long orderId = Long.parseLong(requestData.get("orderId").toString());
        String username = requestData.get("username").toString();
        authenService.orderSuccess(username, orderId);
    }
}
