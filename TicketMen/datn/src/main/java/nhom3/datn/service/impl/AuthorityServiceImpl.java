package nhom3.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.AuthorityDao;
import nhom3.datn.entity.Authority;
import nhom3.datn.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
    @Autowired
    AuthorityDao dao;

    @Override
    public void save(Authority authority) {
        dao.save(authority);
    }
    
}
