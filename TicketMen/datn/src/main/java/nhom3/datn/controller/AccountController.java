package nhom3.datn.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String add(Model model, @ModelAttribute("account") Account account,
            @RequestParam("gender") String gender){
        Authority authority = new Authority();
        Role role = roleService.findById("USER");

        authority.setAccount(account);
        authority.setRole(role);

        System.out.println(gender);
        // account.setGender(gender);
        accountService.save(account);
        authorityService.save(authority);
        return "redirect:/home/index";
    }
}
