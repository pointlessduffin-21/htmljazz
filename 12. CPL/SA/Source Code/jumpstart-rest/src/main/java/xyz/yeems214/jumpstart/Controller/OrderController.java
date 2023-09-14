package xyz.yeems214.jumpstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yeems214.jumpstart.Entity.Order;
import xyz.yeems214.jumpstart.Entity.Product;
import xyz.yeems214.jumpstart.Entity.User;
import xyz.yeems214.jumpstart.Repository.OrderRepository;
import xyz.yeems214.jumpstart.Repository.UserRepository;

import java.util.List;

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
