package xyz.yeems214.jumpstart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.jumpstart.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
