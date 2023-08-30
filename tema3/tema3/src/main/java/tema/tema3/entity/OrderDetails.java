package tema.tema3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;

    private String productCode;

    private Integer quantity;

    private Double priceEach;

}
