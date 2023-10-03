package nhom3.datn.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.CategoryDao;
import nhom3.datn.entity.Category;
import nhom3.datn.service.CategoryService;

@Service 
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryDao cdao;

    @Override
    public List<Category> fillAll() {
       return cdao.findAll();
    }

}
