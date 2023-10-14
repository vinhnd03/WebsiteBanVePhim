package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.RoleDao;
import nhom3.datn.entity.Role;
import nhom3.datn.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDao dao;

    @Override
    public Role findById(String id) {
        return dao.findById(id).get();
    }
    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

   
}
