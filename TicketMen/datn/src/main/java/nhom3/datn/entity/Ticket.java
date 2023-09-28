package nhom3.datn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@SuppressWarnings("*")
@Data
@Entity
@Table(name = "Rooms")
public class Room implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String typeId;
    int seat;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    Date date = new Date();
}
