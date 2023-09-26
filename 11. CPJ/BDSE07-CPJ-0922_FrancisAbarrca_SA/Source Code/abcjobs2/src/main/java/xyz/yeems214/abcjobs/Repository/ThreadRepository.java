package xyz.yeems214.abcjobs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.abcjobs.Entity.Thread;

public interface ThreadRepository extends JpaRepository<Thread, Long> {
}
