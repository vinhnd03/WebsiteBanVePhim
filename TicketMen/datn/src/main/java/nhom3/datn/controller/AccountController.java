package nhom3.datn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import nhom3.datn.entity.Account;
import nhom3.datn.entity.Authority;
import nhom3.datn.entity.Role;
import nhom3.datn.service.AccountService;
import nhom3.datn.service.AuthorityService;
import nhom3.datn.service.RoleService;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @Autowired
    AuthorityService authorityService;

    @PostMapping("account/add")
    public ModelAndView add(ModelMap model, @ModelAttribute("account") Account account,
            @RequestParam("gender") String gender, @RequestParam("confirmPassword") String confirmPassword,
            @RequestParam("password") String password, @RequestParam("username") String username) {
        Authority authority = new Authority();
        Role role = roleService.findById("USER");

        authority.setAccount(account);
        authority.setRole(role);

        Optional<Account> user = accountService.findAccount(username);

        if (user.isPresent()) {
            model.addAttribute("message", "Username đã tồn tại, vui lòng sử dụng username khác.");
            return new ModelAndView("forward:/", model);
        } else {

            if (!password.equals(confirmPassword)) {
                model.addAttribute("message", "Lỗi xác nhận mật khẩu");
                return new ModelAndView("forward:/", model);
            }

            account.setUsername(username.toLowerCase());
            account.setPassword(password.toLowerCase());
            accountService.save(account);
            authorityService.create(authority);
            model.addAttribute("message", "Đăng ký thành công");
            return new ModelAndView("redirect:/", model);
        }
    }
}
