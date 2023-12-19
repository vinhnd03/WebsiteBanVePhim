package nhom3.datn.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Category;
import nhom3.datn.entity.Food;
import nhom3.datn.entity.FoodOrder;
import nhom3.datn.entity.OrderDetail;
import nhom3.datn.service.FoodOrderService;
import nhom3.datn.service.FoodService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/foods")
public class FoodRestController {
    @Autowired
    FoodService foodService;

    @Autowired
    FoodOrderService foodOrderService;

    @GetMapping()
    public List<Food> getAll() {
        return foodService.findAll();
    }

    @PostMapping()
    public FoodOrder create(@RequestBody FoodOrder foodOrder) {
        return foodOrderService.create(foodOrder);
    }
    

    @GetMapping("/getFoodOrder/{id}")
    public List<FoodOrder> getfoodorder(@PathVariable("id") Long id) {
        return foodOrderService.findFoodByOrderId(id);
    }

<<<<<<< HEAD
    // @PostMapping()
    // public Food create(@RequestBody Food food){
    //     return foodService.create(food);
    // }

    // @PutMapping("{id}")
    // public Food update(@PathVariable("id") Long id,
    //     @RequestBody Food food){
    //     return foodService.update(food);
    // }

    // @DeleteMapping("{id}")
    // public void delete(@PathVariable("id") Long id){
    //     foodService.delete(id);
    // }

}
=======
   
}   
>>>>>>> 101c5e83edf4db672a089dbd60e25218d29c6f80
