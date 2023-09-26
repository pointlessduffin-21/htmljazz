package xyz.yeems214.abcjobs.Repository;

import org.springframework.data.repository.CrudRepository;
import xyz.yeems214.abcjobs.Entity.JobApplicant;

import java.util.List;
import java.util.Optional;

public interface JobApplicantRepository extends CrudRepository<JobApplicant, Long> {
    List<JobApplicant> findByJobId(Long jobId);
}


