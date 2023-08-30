package tema.tema3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue
    private Integer customeId;

    private Date paymentDate;

    private Double amount;

}
