package nhom3.datn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import nhom3.datn.entity.Account;
import nhom3.datn.service.AccountService;

public class test {
    @Autowired
    static AccountService accountService;

    public static void main(String[] args) {
        // Account account = accountService.findByToken("33659fcf-9e2b-490f-bdef-78ec005ff506");
        // System.out.println(account.getName());

        Account account2 = accountService.findById("admin");

        System.out.println(account2.getName());
    }
}
