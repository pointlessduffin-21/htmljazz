package xyz.yeems214.abcjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.abcjobs.Entity.Post;
import xyz.yeems214.abcjobs.Repository.PostRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/all")
    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @PostMapping("/add")
    public Post addPost(@RequestBody Post post) {
        post.setPost_dateTime(LocalDateTime.now());
        return postRepository.save(post);
    }

    @PutMapping("/update/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setCreator(updatedPost.getCreator());
                    post.setContent(updatedPost.getContent());
                    post.setPhotoURL(updatedPost.getPhotoURL());
                    post.setLikes(updatedPost.getLikes());
                    post.setPost_dateTime(LocalDateTime.now());
                    return postRepository.save(post);
                })
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}
