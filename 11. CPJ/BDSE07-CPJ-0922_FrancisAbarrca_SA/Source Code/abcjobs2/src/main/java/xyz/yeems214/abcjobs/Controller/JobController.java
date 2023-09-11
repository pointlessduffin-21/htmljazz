package xyz.yeems214.abcjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.abcjobs.Entity.JobApplicant;
import xyz.yeems214.abcjobs.Entity.Jobs;
import xyz.yeems214.abcjobs.Repository.JobApplicantRepository;
import xyz.yeems214.abcjobs.Repository.JobsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job")
public class JobController {
    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private JobApplicantRepository jobApplicantRepository;

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

    @GetMapping("/{jobId}/applicants/all")
    public Iterable<JobApplicant> getAllApplicants(@PathVariable Long jobId) {
        return jobApplicantRepository.findByJobId(jobId);
    }

    @PostMapping("/{jobId}/applicants/add")
    public ResponseEntity<?> addApplicant(@PathVariable Long jobId, @RequestBody JobApplicant applicant) {
        Optional<Jobs> job = jobsRepository.findById(jobId);
        if (!job.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found with id: " + jobId);
        }

        List<JobApplicant> existingApplicants = job.get().getApplicants();
        if (existingApplicants.stream().anyMatch(a -> a.getApplicant_name().equals(applicant.getApplicant_name()))) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User has already applied for this job");
        }

        applicant.setApplication_date(LocalDateTime.now());
        applicant.setJob(job.get());
        JobApplicant savedApplicant = jobApplicantRepository.save(applicant);
        return ResponseEntity.ok(savedApplicant);
    }

}
