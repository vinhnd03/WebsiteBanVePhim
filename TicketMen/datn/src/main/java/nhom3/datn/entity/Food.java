package nhom3.datn.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Foods")
public class Food implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Double price;

    // @JsonIgnore
    // @OneToMany(mappedBy = "food")
    // List<OrderDetail> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "food")
    List<FoodOrder> foodOrders;
}
