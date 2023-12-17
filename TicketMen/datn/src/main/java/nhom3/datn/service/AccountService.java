package nhom3.datn.service;

import java.util.List;
import java.util.Optional;

import nhom3.datn.entity.Account;

public interface AccountService {

    Account findById(String username);

    void save(Account account);

    List<Account> getAdministrators();

    List<Account> findAll();

    Account create(Account account);

    Account update(Account account);

    void delete(String username);

    List<Account> findAllStaff();

    Optional<Account> findAccount(String username);

    Optional<Account> findByEmail(String email);

    Optional<Account> findByToken(String token);

    
}
