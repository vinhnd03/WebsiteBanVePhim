package nhom3.datn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@SuppressWarnings("*")
@Data
@Entity
@Table(name = "Tickets")
public class Ticket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;    
    int seat;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "MovieId")
    Movie movie;

    @ManyToOne
    @JoinColumn(name = "RoomId")
    Room room;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    Order order; 

    @ManyToOne
    @JoinColumn(name = "TyprId")
    TicketType ticketType;
}
