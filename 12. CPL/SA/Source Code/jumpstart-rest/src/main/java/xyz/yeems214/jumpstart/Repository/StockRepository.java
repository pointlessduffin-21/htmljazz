package xyz.yeems214.jumpstart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.jumpstart.Entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
