package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Account;

public interface AccountService {

    Account findById(String username);

    void save(Account account);
    
    List<Account> getAdministrators();

    List<Account> findAll();
}
