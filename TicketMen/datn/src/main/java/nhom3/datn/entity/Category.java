package nhom3.datn.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("*")
@Data
@Entity
@Table(name = "Categories")
public class Category implements Serializable{
    @Id
    String id;
    String name;
}
