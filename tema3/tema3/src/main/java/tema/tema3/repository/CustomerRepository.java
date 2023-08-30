package tema.tema3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tema.tema3.entity.Customer;
import tema.tema3.entity.Order;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer getCustomerByUsername(String username);
}
