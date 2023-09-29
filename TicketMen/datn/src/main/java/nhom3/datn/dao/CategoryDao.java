package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Category;

public interface CategoryDao extends JpaRepository<Category,String> {
    
}
