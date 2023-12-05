package nhom3.datn.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Movie;
import nhom3.datn.entity.OrderDetail;
import nhom3.datn.service.OrderDetailService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderDetails")
public class OrderDetailRestController {
    @Autowired
    OrderDetailService orderService;

    @GetMapping("{id}")
    public OrderDetail getOne(@PathVariable("id") Long id){
        return orderService.findById(id);
    }

    @GetMapping()
    public List<OrderDetail> getAll(){
        return orderService.findAll();
    }

    @PostMapping()
    public OrderDetail create(@RequestBody OrderDetail order){
        return orderService.create(order);
    }

    @GetMapping("/getOrderDetail/{id}")
    public List<OrderDetail> getorderdetail(@PathVariable("id") Long id){
        return orderService.findDetailByOrderId(id);
    }

        @GetMapping("/getOrderDetail/{id}/{tid}")
    public List<OrderDetail> getorderdetail2(@PathVariable("id") Long id,@PathVariable("tid") Long tid){
        return orderService.findDetailByOrderId(id, tid);
    }
}
