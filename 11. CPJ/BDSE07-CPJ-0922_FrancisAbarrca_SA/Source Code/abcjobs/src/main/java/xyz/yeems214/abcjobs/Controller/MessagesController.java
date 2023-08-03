package xyz.yeems214.abcjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import xyz.yeems214.abcjobs.Entity.Messages;
import xyz.yeems214.abcjobs.Repository.MessagesRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/messages")
public class MessagesController {
    @Autowired
    private MessagesRepository messagesRepository;

    @GetMapping("/all")
    public Page<Messages> getAllMessages(@PageableDefault(size = 20, sort = "message_dateTime", direction = Sort.Direction.DESC) Pageable pageable) {
        return messagesRepository.findAll(pageable);
    }

    @PostMapping("/add")
    public Messages addMessages(@RequestBody Messages messages) {
        messages.setMessage_dateTime(LocalDateTime.now());
        return messagesRepository.save(messages);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messagesRepository.deleteById(id);
    }
}