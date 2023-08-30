package tema.tema3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String lastName;

    private String firstName;

    private String phone;

    private String address;

    private String city;

    private String postalCode;

    private String country;
    @OneToMany
    private List<Payment> payments;
    @OneToMany
    private List<Order> orders;


}
