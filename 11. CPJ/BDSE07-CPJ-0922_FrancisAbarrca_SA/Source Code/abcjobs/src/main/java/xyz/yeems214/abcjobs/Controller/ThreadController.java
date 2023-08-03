package xyz.yeems214.abcjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.abcjobs.Entity.Thread;
import xyz.yeems214.abcjobs.Repository.ThreadRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/threads")
public class ThreadController {
    @Autowired
    private ThreadRepository threadRepository;

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

}
