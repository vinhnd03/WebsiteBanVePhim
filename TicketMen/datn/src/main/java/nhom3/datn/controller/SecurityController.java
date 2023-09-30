package nhom3.datn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @RequestMapping("/security/login/form")
    public String loginForm(Model model){
        model.addAttribute("message", "Vui lòng đăng nhập");
        return "layout/index";
    }

    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message", "Đăng nhập thành công");
        return  "layout/index";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model){
        model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "layout/index";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message", "Không có quyền truy xuất!");
        return "layout/index";
    }

    @RequestMapping("/security/logoff/success")
    public String logoutSuccess(Model model){
        model.addAttribute("message", "Bạn đã đăng xuất");
        return "layout/index";
    }

}
