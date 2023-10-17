package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.AccountDao;
import nhom3.datn.dao.AuthorityDao;
import nhom3.datn.entity.Account;
import nhom3.datn.entity.Authority;
import nhom3.datn.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
    @Autowired
    AuthorityDao dao;

    @Autowired
    AccountDao acdao;

    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<Account> accounts = acdao.getAdministrators();
        return dao.authoritiesOf(accounts);
    }

    @Override
    public List<Authority> findAll() {
        return dao.findAll();
    }

    @Override
    public Authority create(Authority auth) {
       return dao.save(auth);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
