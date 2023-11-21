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
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // @Temporal(TemporalType.DATE)
    // @Column(name = "Buydate")
    // Date buyDate = new Date();

    @ManyToOne
    @JoinColumn(name = "Ticketid")
    Ticket ticket; 

    @ManyToOne
    @JoinColumn(name = "Orderid")
    Order order;

    @ManyToOne
    @JoinColumn(name = "Typeid")
    TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "Seatid")
    Seat seat;
}
