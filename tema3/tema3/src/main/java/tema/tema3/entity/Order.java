package tema.tema3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    private Date ordeDate;

    private Date shippdeDate;

    private String status;

    private String comments;

    @OneToMany
    private List<OrderDetails> orderDetailsList;
    @JsonIgnore
    @ManyToOne
    Customer customer;
}
