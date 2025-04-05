package xyz.yeems214.jumpstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.yeems214.jumpstart.Repository.OrderRepository;
import xyz.yeems214.jumpstart.Repository.UserRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all-orders/{id}")
    public String getAllOrdersByUserId(Long id) {
        return orderRepository.findAll().toString();
    }

}
