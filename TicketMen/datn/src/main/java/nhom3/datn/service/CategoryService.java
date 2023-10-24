package nhom3.datn.service;

import java.util.List;


import nhom3.datn.entity.Category;
import nhom3.datn.entity.Movie;


public interface CategoryService {
    List<Category> fillAll();

    Category findById(Integer id);

    Category create(Category category);

    Category update(Category category);

    void delete(Integer id);
}
