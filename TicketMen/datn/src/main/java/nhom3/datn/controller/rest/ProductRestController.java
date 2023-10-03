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

import nhom3.datn.entity.Movie;
import nhom3.datn.service.ProductService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("{id}")
    public Movie getOne(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @GetMapping()
    public List<Movie> getAll(){
        return productService.findAll();
    }

    @PostMapping()
    public Movie create(@RequestBody Movie movie){
        return productService.create(movie);
    }

    @PutMapping("{id}")
    public Movie update(@PathVariable("id") Long id,
        @RequestBody Movie movie){
        return productService.update(movie);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
