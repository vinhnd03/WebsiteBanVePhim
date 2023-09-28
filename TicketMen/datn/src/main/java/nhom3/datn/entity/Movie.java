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
@Table(name =  "Movies")
public class Movie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String categoryId;
    String name;
    String studio;
    int age;

    @Temporal(TemporalType.DATE)
    @Column(name = "Showtime")
    Date showtime = new Date();
}
