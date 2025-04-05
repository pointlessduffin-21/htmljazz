package xyz.yeems214.abcjobs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yeems214.abcjobs.Repository.JobApplicantRepository;

@Service
public class JobApplicantService {
    @Autowired
    private JobApplicantRepository jobApplicantRepository;
}
