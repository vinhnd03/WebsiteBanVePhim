package nhom3.datn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{
    @Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('ADMIN', 'STAFF')")
    List<Account> getAdministrators();
}
