package xyz.yeems214.abcjobs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yeems214.abcjobs.Entity.Comment;
import xyz.yeems214.abcjobs.Repository.CommentRepository;

import java.time.LocalDateTime;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        comment.setComment_dateTime(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setCreator(updatedComment.getCreator());
                    comment.setComment_content(updatedComment.getComment_content());
                    comment.setComment_likes(updatedComment.getComment_likes());
                    comment.setComment_dateTime(LocalDateTime.now());
                    return commentRepository.save(comment);
                })
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
