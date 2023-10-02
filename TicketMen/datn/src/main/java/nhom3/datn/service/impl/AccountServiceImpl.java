package nhom3.datn.service.impl;

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

}
