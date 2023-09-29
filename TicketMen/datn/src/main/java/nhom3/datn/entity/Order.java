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

@SuppressWarnings("*")
@Data
@Entity
@Table(name = "Orders")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgayMua")
    Date ngayMua = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "username")
    Account account;
}
