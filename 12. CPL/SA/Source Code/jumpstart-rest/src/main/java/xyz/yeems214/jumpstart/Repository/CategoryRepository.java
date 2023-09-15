package xyz.yeems214.jumpstart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.jumpstart.Entity.Category;
import xyz.yeems214.jumpstart.Entity.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    Category findById(long id);
}
