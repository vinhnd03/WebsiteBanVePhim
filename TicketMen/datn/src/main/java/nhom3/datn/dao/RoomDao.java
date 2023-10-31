package nhom3.datn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nhom3.datn.entity.Room;
import nhom3.datn.entity.Ticket;

public interface RoomDao extends JpaRepository<Room, Integer>{
    
}
