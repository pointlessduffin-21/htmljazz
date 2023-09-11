package xyz.yeems214.abcjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import xyz.yeems214.abcjobs.Entity.Post;
import xyz.yeems214.abcjobs.Repository.PostRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public Post addPost(@RequestPart("post") Post post, @RequestPart("file") MultipartFile file) {
        try {
            // Save the uploaded file to the server
            byte[] bytes = file.getBytes();
            Path path = Paths.get("src/main/resources/images/" + file.getOriginalFilename());
            Files.write(path, bytes);

            // Set the photoURL of the post
            post.setPhotoURL("http://100.77.207.39:5637/images/" + file.getOriginalFilename());
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }

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
