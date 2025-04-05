package xyz.yeems214.kyn.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import xyz.yeems214.kyn.Entity.Message;
import xyz.yeems214.kyn.Service.MessageService;

@RestController
public class MessageController {
    private final MessageService messageService;
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/messages/{userName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String sendMessage(@PathVariable String userName, @RequestBody Message message) throws JsonProcessingException {
        System.out.println(userName);
        System.out.println(message.getText());
        messageService.sendMessage(userName, message);

        return "Message sent!";
    }
}