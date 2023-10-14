package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Authority;

public interface AuthorityService {

    List<Authority> findAuthoritiesOfAdministrators();

    List<Authority> findAll();

    Authority create(Authority auth);

    void delete(Integer id);
}
