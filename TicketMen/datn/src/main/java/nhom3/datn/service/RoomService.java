package nhom3.datn.service;

import java.util.List;

import nhom3.datn.entity.Room;

public interface RoomService {

    Room findById(Integer id);

    List<Room> findAll();

    Room create(Room room);

    Room update(Room room);

    void delete(Integer id);

    
    
}
