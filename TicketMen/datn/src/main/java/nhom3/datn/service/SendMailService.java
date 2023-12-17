package nhom3.datn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendMailService {

    @Autowired
    private TemplateEngine templateEngine;

    private final EmailService emailService;

    
    public void sendMailRequestResetPassword(String link, String email, String fullname) {
        Context context = new Context();
        context.setVariable("link", link);

        String contextHtml = templateEngine.process("/auth/sendMailResetPassword.html", context);

        emailService.sendSimpleMail("YÊU CẦU THAY ĐỔI MẬT KHẨU", contextHtml, email);
    }
}
