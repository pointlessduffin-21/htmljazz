package xyz.yeems214.abcjobs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yeems214.abcjobs.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}