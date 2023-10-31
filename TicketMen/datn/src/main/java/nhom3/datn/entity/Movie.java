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
@Table(name =  "Movies")
public class Movie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String country;
    Integer age;
    String poster;

    //New
    String description;

    @Column(name = "Moviecontent")
    String movieContent;
    
    Integer duration;

    @Temporal(TemporalType.DATE)
    @Column(name = "Releasedate")
    Date releaseDate = new Date();

    // @Temporal(TemporalType.TIME)
    // @Column(name = "Time")
    // Date time = new Date();

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    // String time;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "Categoryid")
    Category category;

    
}
