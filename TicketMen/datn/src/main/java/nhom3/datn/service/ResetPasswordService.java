package nhom3.datn.service;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nhom3.datn.dao.AccountDao;
import nhom3.datn.entity.Account;

@Service
@RequiredArgsConstructor
public class ResetPasswordService {
    //test
    private final AccountDao accountService;
    private final SendMailService sendMailService;

    @Value("http://localhost:8080/auth/reset-password?token=")
    private String resetPasswordLink;
    
    public void requestForgotPassword(String username) {
        Account user = accountService.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy người dùng có username: " + username));



        String token = UUID.randomUUID().toString();
        user.setToken(token);

        String link = resetPasswordLink + token;

        accountService.save(user);

        // thực hiện gửi mail reset password tai day
        // Du lieu truyen di gom link va user
        sendMailService.sendMailRequestResetPassword(link, user.getEmail(), user.getName());
    }
}