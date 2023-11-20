package nhom3.datn.service;

import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import nhom3.datn.entity.Account;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendEmail(String to, String subject, Map<String, Object> model, String templateName) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);

            String content = templateEngine.process(templateName, new Context(Locale.getDefault(), model));
            helper.setText(content, true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail(String to, Account account) {
        
        MimeMessage message = javaMailSender.createMimeMessage();
        String subject = "Tìm lại mật khẩu";
        String content = "Bạn vừa xác nhận quên mật khẩu ở Website TicketMen. Đây là mật khẩu của bạn: " + account.getPassword();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
    
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}