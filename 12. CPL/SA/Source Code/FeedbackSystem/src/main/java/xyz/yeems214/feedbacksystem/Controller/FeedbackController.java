package xyz.yeems214.feedbacksystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.feedbacksystem.Entity.Feedback;
import xyz.yeems214.feedbacksystem.Repository.FeedbackRepository;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/all")
    public Iterable<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @PostMapping("/add")
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        feedback.setIssue_timestamp(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }
}
