package nhom3.datn.controller.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Category;
import nhom3.datn.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("{id}")
    public Category getOne(@PathVariable("id") Integer id){
        return categoryService.findById(id);
    }

    @GetMapping()
    public List<Category> getAll(){
        return categoryService.fillAll();
    }
        @PostMapping()
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable("id") Integer id,
        @RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
    }
}
