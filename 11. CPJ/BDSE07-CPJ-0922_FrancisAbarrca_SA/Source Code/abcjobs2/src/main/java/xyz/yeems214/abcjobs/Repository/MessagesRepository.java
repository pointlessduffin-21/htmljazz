package xyz.yeems214.abcjobs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.abcjobs.Entity.Messages;

public interface MessagesRepository extends JpaRepository<Messages, Long> {
}
