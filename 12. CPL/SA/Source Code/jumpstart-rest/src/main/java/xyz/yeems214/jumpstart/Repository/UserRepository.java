package xyz.yeems214.jumpstart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.jumpstart.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);
}
