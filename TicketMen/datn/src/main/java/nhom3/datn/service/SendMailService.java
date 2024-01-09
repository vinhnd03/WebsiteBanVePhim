package nhom3.datn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lombok.RequiredArgsConstructor;
import nhom3.datn.entity.FoodOrder;
import nhom3.datn.entity.Order;
import nhom3.datn.entity.OrderDetail;

@Service
@RequiredArgsConstructor
public class SendMailService {

    @Autowired
    private TemplateEngine templateEngine;

    private final EmailService emailService;

    
    public void sendMailRequestResetPassword(String link, String email, String fullname) {
        Context context = new Context();
        context.setVariable("link", link);

        String contextHtml = templateEngine.process("/email/sendMailResetPassword.html", context);

        emailService.sendSimpleMail("YÊU CẦU THAY ĐỔI MẬT KHẨU", contextHtml, email);
    }

    public void sendMailOrderNoti(Order order, String link, String email, String username, List<OrderDetail> details, List<FoodOrder> foodOrders) {
        Context context = new Context();
        context.setVariable("link", link);
        context.setVariable("order", order);
        context.setVariable("seat", details);
        context.setVariable("username", username);
        context.setVariable("detail", details.get(0));
        context.setVariable("foodOrder", foodOrders);

        String contextHtml = templateEngine.process("/email/sendMailOrderSuccess.html", context);

        emailService.sendSimpleMail("XÁC NHẬN THANH TOÁN HÓA ĐƠN", contextHtml, email);
    }
}
