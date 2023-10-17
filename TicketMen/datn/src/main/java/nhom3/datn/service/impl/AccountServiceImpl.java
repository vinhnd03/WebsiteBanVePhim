package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.AccountDao;
import nhom3.datn.entity.Account;
import nhom3.datn.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountDao dao;

    @Override
    public Account findById(String username) {
        return dao.findById(username).get();
    }

    @Override
    public void save(Account account) {
        dao.save(account);
    }   

    // hoang them
    public List<Account> getAdministrators() {
        return dao.getAdministrators();
    }

    
    public List<Account> findAll() {
        return dao.findAll();

}
}
