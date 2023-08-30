package tema.tema3.dto;

import lombok.Data;
import tema.tema3.entity.Customer;

@Data
public class PostalDetailsUserDTO {
    private String address;
    private String phone;
    private String city;
    public PostalDetailsUserDTO(Customer customer) {
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.city = customer.getCity();
    }
}
