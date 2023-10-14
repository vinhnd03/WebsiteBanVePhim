package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Role;

public interface RoleService {

    Role findById(String id);
    
    List<Role> findAll();
}
