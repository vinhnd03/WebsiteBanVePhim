package nhom3.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nhom3.datn.entity.Room;

public interface RoomDao extends JpaRepository<Room, String>{
    
}
