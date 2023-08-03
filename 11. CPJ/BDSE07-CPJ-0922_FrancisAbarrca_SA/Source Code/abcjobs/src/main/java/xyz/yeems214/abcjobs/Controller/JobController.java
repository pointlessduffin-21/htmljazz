package xyz.yeems214.abcjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.abcjobs.Entity.Jobs;
import xyz.yeems214.abcjobs.Repository.JobsRepository;

import java.time.LocalDateTime;

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
        jobs.setJob_creation(LocalDateTime.now());
        return jobsRepository.save(jobs);
    }

    @PutMapping("/update/{id}")
    public Jobs updateJob(@PathVariable Long id, @RequestBody Jobs updatedJob) {
        return jobsRepository.findById(id)
                .map(job -> {
                    job.setCreator(updatedJob.getCreator());
                    job.setJob_title(updatedJob.getJob_title());
                    job.setJob_description(updatedJob.getJob_description());
                    job.setCompany_name(updatedJob.getCompany_name());
                    job.setJob_type(updatedJob.getJob_type());
                    job.setJob_interested(updatedJob.getJob_interested());
                    job.setJob_creation(LocalDateTime.now());
                    job.setJob_range(updatedJob.getJob_range());
                    job.setJob_status(updatedJob.getJob_status());
                    return jobsRepository.save(job);
                })
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobsRepository.deleteById(id);
    }

}
