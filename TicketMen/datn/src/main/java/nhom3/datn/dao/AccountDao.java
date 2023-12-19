package nhom3.datn.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nhom3.datn.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{
    @Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('ADMIN', 'STAFF')")
    List<Account> getAdministrators();

    @Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('STAFF')")
    List<Account> getStaff();

    @Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('USER')")
    List<Account> getUser();

     @Query("SELECT a FROM Account a WHERE a.email = :email")
    Optional <Account> findByEmail(@Param("email") String email);
}
