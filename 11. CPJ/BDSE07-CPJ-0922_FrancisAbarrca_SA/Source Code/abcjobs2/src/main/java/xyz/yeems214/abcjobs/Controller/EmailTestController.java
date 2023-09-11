package xyz.yeems214.abcjobs.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import xyz.yeems214.abcjobs.Service.EmailTestService;


@RestController
@RequestMapping("/api/test")
public class EmailTestController {
    private final EmailTestService emailTestService;

    public EmailTestController(EmailTestService emailTestService) {
        this.emailTestService = emailTestService;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String content) {
        try {
            emailTestService.sendEmail(to, subject, content);
            return ResponseEntity.ok("Email sent to: " + to);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
        }
    }
}
