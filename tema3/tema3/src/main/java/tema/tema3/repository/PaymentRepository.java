package tema.tema3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tema.tema3.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
