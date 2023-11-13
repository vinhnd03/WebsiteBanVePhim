package nhom3.datn.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Tickets")
public class Ticket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Float price;
    Boolean available;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    Date date = new Date();

    @Temporal(TemporalType.TIME)
    @Column(name = "Time")
    Date time = new Date();

    @ManyToOne
    @JoinColumn(name = "Movieid")
    Movie movie;

    @ManyToOne
    @JoinColumn(name = "Roomid")
    Room room;


    @JsonIgnore
    @OneToMany(mappedBy = "ticket")
    List<Order> orders;
}
