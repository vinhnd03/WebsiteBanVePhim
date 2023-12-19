package nhom3.datn.service.impl;

import java.util.List;
import java.util.Optional;

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

        @Override
        public Account create(Account account) {
            return dao.save(account);
        }

        @Override
        public Account update(Account account) {
           return dao.save(account);
        }

        @Override
        public void delete(String username) {
            dao.deleteById(username);
        }

        @Override
        public List<Account> findAllStaff() {
            return dao.getStaff();
        }

        // @Override
        // public List<Account> findAllUser() {
        //     return dao.getUser();
        // }

        @Override
        public Optional<Account> findAccount(String username) {
            return dao.findById(username);
        }

        @Override
        public Optional<Account> findByEmail(String email) {
           return dao.findByEmail(email);
        }

        @Override
<<<<<<< HEAD
        public List<Account> findAllUser() {
            // TODO Auto-generated method stub
            return dao.getUser();
=======
        public Optional <Account> findByToken(String token) {
            return dao.findByToken(token);
>>>>>>> c01bcc659d84e7d7eb106a2946293462178d105e
        }
}
