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

import nhom3.datn.entity.Room;
import nhom3.datn.service.RoomService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/rooms")
public class RoomRestController {
       @Autowired
    RoomService roomService;

    @GetMapping("{id}")
    public Room getOne(@PathVariable("id") Integer id){
        return roomService.findById(id);
    }

    @GetMapping()
    public List<Room> getAll(){
        return roomService.findAll();
    }

    @PostMapping()
    public Room create(@RequestBody Room room){
        return roomService.create(room);
    }

    @PutMapping("{id}")
    public Room update(@PathVariable("id") Integer id,
        @RequestBody Room room){
        return roomService.update(room);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        roomService.delete(id);
    }
}
