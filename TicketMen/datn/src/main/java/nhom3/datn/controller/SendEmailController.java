package nhom3.datn.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import nhom3.datn.entity.Account;
import nhom3.datn.service.AccountService;
import nhom3.datn.service.ResetPasswordService;
import nhom3.datn.service.SendMailService;

@Controller
// @RequiredArgsConstructor
public class SendEmailController {
    @Autowired
    ResetPasswordService authenService;

    @Autowired
    AccountService accountService;

    @PostMapping("auth/requestResetPassword")
    public String requestResetPassword(Model model, @RequestParam String username){

        Optional<Account> account = accountService.findAccount(username);

        if(account.isPresent()){
            authenService.requestForgotPassword(username);
            model.addAttribute("message", "Vui lòng kiểm tra Mail của bạn.");
        }else{
            model.addAttribute("error", "Tài khoản không tồn tại.");
        }
        return "security/forgot";
    }

    @GetMapping("auth/reset-password")
    public String resetPassword(Model model, @RequestParam("token") String token){
        model.addAttribute("token", token);
        Optional<Account> account = accountService.findByToken(token);
        if(!account.isPresent()){
            model.addAttribute("message", "Đường dẫn đã hết hiệu lực!");
        }
        return "security/reset-password";
    }

    @PostMapping("auth/reset")
    public String resetPassword(Model model, @RequestParam("password") String password, @RequestParam("token") String token){
        System.out.println("token: " + token);
        Optional<Account> account = accountService.findByToken(token);

        if(!account.isPresent()){
            model.addAttribute("message", "Đường dẫn đã hết hạn!");
        }


        account.get().setPassword(password);
        accountService.save(account.get());
        model.addAttribute("message", "Đặt lại mật khẩu thành công.");
        return "security/reset-password";
    }

}
