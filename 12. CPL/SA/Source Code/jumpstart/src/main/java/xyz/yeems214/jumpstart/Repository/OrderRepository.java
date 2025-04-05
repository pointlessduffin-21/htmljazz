package xyz.yeems214.jumpstart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.jumpstart.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
