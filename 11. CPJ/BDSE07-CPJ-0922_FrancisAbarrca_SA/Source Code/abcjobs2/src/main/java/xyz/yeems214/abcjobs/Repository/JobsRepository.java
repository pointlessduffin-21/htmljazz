package xyz.yeems214.abcjobs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.abcjobs.Entity.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
}
