package nhom3.datn.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Movie;
import nhom3.datn.entity.Order;
import nhom3.datn.entity.OrderDetail;
import nhom3.datn.service.OrderDetailService;
import nhom3.datn.service.OrderService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @GetMapping("{id}")
    public Order getOne(@PathVariable("id") Long id){
        return orderService.findById(id);
    }

    @GetMapping()
    public List<Order> getAll(){
        return orderService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        orderService.delete(id);
    }

    @PostMapping()
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }

    @GetMapping("/getOrderUsername/{username}")
    public List<Order> getorderusername(@PathVariable("username") String username){
        return orderService.findByUsername(username);
    }
}
