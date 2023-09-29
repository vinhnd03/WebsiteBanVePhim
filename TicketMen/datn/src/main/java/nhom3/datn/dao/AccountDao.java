package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{
    
}
