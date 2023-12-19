package nhom3.datn.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nhom3.datn.dao.AccountDao;
import nhom3.datn.entity.Account;
import nhom3.datn.entity.FoodOrder;
import nhom3.datn.entity.Order;
import nhom3.datn.entity.OrderDetail;

@Service
@RequiredArgsConstructor
public class ResetPasswordService {
    //test
    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService; 

    @Autowired
    FoodOrderService foodOrderService; 

    private final AccountDao accountService;
    private final SendMailService sendMailService;

    @Value("http://localhost:8080/auth/reset-password?token=")
    private String resetPasswordLink;

    @Value("http://localhost:8080/user")
    private String userLink;

    
    public void requestForgotPassword(String username) {
        Account user = accountService.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy người dùng có username: " + username));

        String token = UUID.randomUUID().toString();
        user.setToken(token);

        String link = resetPasswordLink + token;

        accountService.save(user);

        sendMailService.sendMailRequestResetPassword(link, user.getEmail(), user.getName());
    }

    public void orderSuccess(String username,  Long id){
        Account user = accountService.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy người dùng có username: " + username));

        Order order = orderService.findById(id);
        List<OrderDetail> details = orderDetailService.findDetailByOrderId(id);
        List<FoodOrder> foodOrders = foodOrderService.findFoodByOrderId(id);


        sendMailService.sendMailOrderNoti(order, userLink, user.getEmail(), user.getUsername(), details, foodOrders);       
    }
}