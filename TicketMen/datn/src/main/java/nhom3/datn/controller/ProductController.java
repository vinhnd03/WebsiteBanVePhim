
package nhom3.datn.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nhom3.datn.entity.Movie;
import nhom3.datn.service.ProductService;


@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<String> cid) {
        if (cid.isPresent()) {
            List<Movie> list = productService.findByCategoryId(cid.get());
            model.addAttribute("items", list);
        } else {
            List<Movie> list = productService.findAll();
            model.addAttribute("items", list);
        }
        return "product/list";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Movie item = productService.findById(id);
        model.addAttribute("item", item);
        return "product/detail";
    }

}