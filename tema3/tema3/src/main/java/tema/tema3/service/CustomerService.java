package tema.tema3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tema.tema3.dto.PostalDetailsUserDTO;
import tema.tema3.entity.Customer;
import tema.tema3.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public PostalDetailsUserDTO getPostalDetailsByUsername(String username) {
        System.out.println(username);
        Customer customer = customerRepository.getCustomerByUsername(username);
        System.out.println(customer);
        if (customer != null) {
            PostalDetailsUserDTO dto = new PostalDetailsUserDTO(customer);
            return dto;
        }
        return null;
    }
}
