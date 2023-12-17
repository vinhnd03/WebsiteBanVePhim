package nhom3.datn.service;

import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import nhom3.datn.entity.Account;

@Service
public class EmailService {
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;


    @Value("lehuutuong.312@gmail.com")
    private String sender;

    
    public void sendSimpleMail(String subject, String body, String recipient) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(sender);
            helper.setTo(recipient);
            helper.setSubject(subject);
            helper.setText(body, true); // Set the HTML content

            javaMailSender.send(message);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ApplicationContextException("Gửi mail không thành công!");
        }
    }


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