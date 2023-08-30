package tema.tema3.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tema.tema3.dto.PostalDetailsUserDTO;
import tema.tema3.entity.Customer;
import tema.tema3.entity.Order;
import tema.tema3.entity.OrderDetails;
import tema.tema3.service.CustomerService;
import tema.tema3.service.OrderDetailsService;
import tema.tema3.service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailsService orderDetailsService;
    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        Customer customer1 = new Customer();
        //hardcoded
        customer1.setFirstName("Andrei");
        customerService.addCustomer(customer1);
        return customer1;

        //decomment pt non hardcoded
        //return customerService.addCustomer(customer1);

    }
    @GetMapping("/user/{username}/postalDetails")
    public PostalDetailsUserDTO getPostalDetails(@PathVariable String username) {
        return customerService.getPostalDetailsByUsername(username);
    }
    @GetMapping("/orders/{id}")
    public List<Order> customerOrders(@PathVariable Integer id) {
        return orderService.getOrders(id);
    }

    @PostMapping("/create_order")
    public Order createOrder(Customer customer) {
        Order order = new Order();
        order.setOrdeDate(new Date());
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderDetails orderDetails1 = new OrderDetails();
        OrderDetails orderDetails2 = new OrderDetails();
        OrderDetails orderDetails3 = new OrderDetails();
        OrderDetails orderDetails4 = new OrderDetails();
        OrderDetails orderDetails5 = new OrderDetails();

        orderDetails1.setProductCode("425acbd9-83fd-4be9-bcab-cadd96cee4e5");
        orderDetails2.setProductCode("425acbd9-83fd-4be9-bcab-cadd96cee4e5");
        orderDetails3.setProductCode("425acbd9-83fd-4be9-bcab-cadd96cee4e5");
        orderDetails4.setProductCode("425acbd9-83fd-4be9-bcab-cadd96cee4e5");
        orderDetails5.setProductCode("425acbd9-83fd-4be9-bcab-cadd96cee4e5");
        orderDetailsList.add(orderDetails1);
        orderDetailsList.add(orderDetails2);
        orderDetailsList.add(orderDetails3);
        orderDetailsList.add(orderDetails4);
        orderDetailsList.add(orderDetails5);
        for(OrderDetails orderDetails : orderDetailsList) {
            orderDetailsService.addOrderDetails(orderDetails);
        }
        order.setOrderDetailsList(orderDetailsList);
        orderService.addOrder(order);
        Customer c2 = new Customer();
        List<Order> orders = new ArrayList<>();
        c2.setOrders(orders);
        c2.setLastName("Vasile");
        order.setCustomer(c2);
        customerService.addCustomer(c2);



        return null;
    }
}
