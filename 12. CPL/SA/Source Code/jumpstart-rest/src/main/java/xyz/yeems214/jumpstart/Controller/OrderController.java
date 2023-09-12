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

    @PostMapping("/place-order")
    public ResponseEntity<?> placeOrder(@RequestBody Order order, @RequestParam("user_id") Long userId) {
        // Fetch the User entity using the provided ID
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);

        // Validate the products
        List<Product> products = order.getProducts();
        if (products == null || products.isEmpty()) {
            return new ResponseEntity<>("No products provided.", HttpStatus.BAD_REQUEST);
        }

        // Validate the quantity
        Long quantity = order.getQuantity();
        if (quantity == null || quantity <= 0) {
            return new ResponseEntity<>("Invalid quantity.", HttpStatus.BAD_REQUEST);
        }

        // Calculate the total price
        long totalPrice = products.stream()
                .mapToLong(product -> product.getPrice() * quantity)
                .sum();
        order.setTotal_price(totalPrice);

        // Save the order to the database
        Order placedOrder;
        try {
            placedOrder = orderRepository.save(order);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to place order.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Return a response
        return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
    }


}
