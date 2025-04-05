package xyz.yeems214.jumpstart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.jumpstart.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
