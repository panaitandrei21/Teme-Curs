package tema.tema3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tema.tema3.entity.Customer;
import tema.tema3.entity.Order;
import tema.tema3.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order addOrder(Order o) {
        return orderRepository.save(o);
    }
    public List<Order> getOrders(Integer id) {
        return orderRepository.getOrdersByCustomerId(id);
    }
}
