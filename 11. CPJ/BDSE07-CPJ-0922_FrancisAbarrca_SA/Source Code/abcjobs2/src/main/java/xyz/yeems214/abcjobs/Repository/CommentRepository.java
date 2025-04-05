package xyz.yeems214.abcjobs.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.yeems214.abcjobs.Entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
