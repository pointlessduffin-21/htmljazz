package xyz.yeems214.abcjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job")
public class JobController {
    @Autowired
    private JobsRepository jobsRepository;

    @GetMapping("/all")
    public Iterable<Jobs> getAllJobs() {
        return jobsRepository.findAll();
    }

    @PostMapping("/add")
    public Jobs addJobs(@RequestBody Jobs jobs) {
        jobs.setIssue_timestamp(LocalDateTime.now());
        return jobsRepository.save(jobs);
    }

}
