package nhom3.datn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom3.datn.dao.RoomDao;
import nhom3.datn.entity.Room;
import nhom3.datn.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{ 
    @Autowired
    RoomDao dao;

    @Override
    public Room findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Room> findAll() {
        return dao.findAll();
    }

    @Override
    public Room create(Room room) {
        return dao.save(room);
    }

    @Override
    public Room update(Room room) {
        return dao.save(room);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
