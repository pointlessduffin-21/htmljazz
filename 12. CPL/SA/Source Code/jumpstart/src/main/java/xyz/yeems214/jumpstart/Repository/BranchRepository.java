package xyz.yeems214.jumpstart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.jumpstart.Entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
