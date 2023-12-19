package nhom3.datn.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nhom3.datn.entity.Account;
import nhom3.datn.service.AccountService;
import nhom3.datn.service.EmailService;

@Controller
public class SecurityController {
    @Autowired
    AccountService accountService;

    @Autowired
    EmailService emailService;

    @RequestMapping("/security/login/form")
    public String loginForm(Model model){
        model.addAttribute("message", "Vui lòng đăng nhập");
        return "forward:/";
    }

    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message", "Đăng nhập thành công");
        return "forward:/";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model){
        model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "forward:/";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message", "Không có quyền truy xuất!");
        return "forward:/";
    }

    @RequestMapping("/security/logoff/success")
    public String logoutSuccess(Model model){
        model.addAttribute("message", "Bạn đã đăng xuất");
        return "redirect:/";
    }

    @GetMapping("/security/forgot")
    public String forgot(Model model){     
        return "security/forgot";
    }

    // @RequestMapping("/security/sendMail")
    // public String sendEmail(Model model, @RequestParam(name = "emailConfirm", required = false) String email){ 

    //     if (StringUtils.hasText(email)) {
    //         Optional<Account> account = accountService.findByEmail(email);
    //         if(account.isPresent()){
    //             emailService.sendEmail(email, account.get());
    //             model.addAttribute("message", "Vui long xac nhan tai khoan trong email");
    //             return "/security/forgot";
    //         }else{
    //             model.addAttribute("message", "Email chua duoc dang ky");
    //             return "/security/forgot";
    //         }
            
	// 	} 
    //     return "/security/forgot";       
    //}
}
