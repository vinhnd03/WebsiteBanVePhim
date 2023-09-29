package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Role;

public interface RoleDao extends JpaRepository<Role, String>{
    
}
