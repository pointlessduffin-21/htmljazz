package xyz.yeems214.abcjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.abcjobs.Entity.Comment;
import xyz.yeems214.abcjobs.Entity.Thread;
import xyz.yeems214.abcjobs.Repository.CommentRepository;
import xyz.yeems214.abcjobs.Repository.ThreadRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/threads")
public class ThreadController {
    @Autowired
    private ThreadRepository threadRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/all")
    public Iterable<Thread> getAllThreads() {
        return threadRepository.findAll();
    }

    @PostMapping("/add")
    public Thread addThread(@RequestBody Thread thread) {
        thread.setThread_dateTime(LocalDateTime.now());
        return threadRepository.save(thread);
    }

    @PutMapping("/update/{id}")
    public Thread updateThread(@PathVariable Long id, @RequestBody Thread updatedThread) {
        return threadRepository.findById(id)
                .map(thread -> {
                    thread.setCreator(updatedThread.getCreator());
                    thread.setThread_title(updatedThread.getThread_title());
                    thread.setThread_content(updatedThread.getThread_content());
                    thread.setThread_likes(updatedThread.getThread_likes());
                    thread.setThread_dateTime(LocalDateTime.now());
                    return threadRepository.save(thread);
                })
                .orElseThrow(() -> new RuntimeException("Thread not found with id: " + id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteThread(@PathVariable Long id) {
        threadRepository.deleteById(id);
    }

    @GetMapping("/{threadId}/comments/all")
    public Iterable<Comment> getAllComments(@PathVariable Long threadId) {
        return threadRepository.findById(threadId)
                .map(thread -> thread.getComments())
                .orElseThrow(() -> new RuntimeException("Thread not found with id: " + threadId));
    }

    @PostMapping("/{threadId}/comments/add")
    public Comment addComment(@PathVariable Long threadId, @RequestBody Comment comment) {
        return threadRepository.findById(threadId)
                .map(thread -> {
                    comment.setComment_dateTime(LocalDateTime.now());
                    Comment savedComment = commentRepository.save(comment);
                    thread.getComments().add(savedComment);
                    threadRepository.save(thread);
                    return savedComment;
                })
                .orElseThrow(() -> new RuntimeException("Thread not found with id: " + threadId));
    }

    @PutMapping("/{threadId}/comments/update/{commentId}")
    public Comment updateComment(@PathVariable Long threadId, @PathVariable Long commentId, @RequestBody Comment updatedComment) {
        if (!threadRepository.existsById(threadId)) {
            throw new RuntimeException("Thread not found with id: " + threadId);
        }
        return commentRepository.findById(commentId)
                .map(comment -> {
                    comment.setCreator(updatedComment.getCreator());
                    comment.setComment_content(updatedComment.getComment_content());
                    comment.setComment_likes(updatedComment.getComment_likes());
                    comment.setComment_dateTime(LocalDateTime.now());
                    return commentRepository.save(comment);
                })
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));
    }

    @DeleteMapping("/{threadId}/comments/delete/{commentId}")
    public void deleteComment(@PathVariable Long threadId, @PathVariable Long commentId) {
        if (!threadRepository.existsById(threadId)) {
            throw new RuntimeException("Thread not found with id: " + threadId);
        }
        if (!commentRepository.existsById(commentId)) {
            throw new RuntimeException("Comment not found with id: " + commentId);
        }
        commentRepository.deleteById(commentId);
    }
}
