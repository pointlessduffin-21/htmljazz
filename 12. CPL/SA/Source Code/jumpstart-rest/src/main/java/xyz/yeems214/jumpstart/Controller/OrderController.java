package xyz.yeems214.jumpstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yeems214.jumpstart.Repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/all-orders/{id}")
    public String getAllOrdersByUserId(Long id) {
        return orderRepository.findAll().toString();
    }
}
