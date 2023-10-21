package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Account;
import nhom3.datn.entity.Category;

public interface AccountService {

    Account findById(String username);

    void save(Account account);

    List<Account> getAdministrators();

    List<Account> findAll();

    Account create(Account account);

    Account update(Account account);

    void delete(String username);
}
