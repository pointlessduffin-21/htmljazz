package xyz.yeems214.abcjobs.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JobApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String applicant_name;
    private LocalDateTime application_date;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonBackReference
    private Jobs job;

    public JobApplicant() {
    }

    public JobApplicant(String applicant_name, LocalDateTime application_date, Jobs job) {
        this.applicant_name = applicant_name;
        this.application_date = application_date;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public LocalDateTime getApplication_date() {
        return application_date;
    }

    public Jobs getJob() {
        return job;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public void setApplication_date(LocalDateTime application_date) {
        this.application_date = application_date;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "JobApplicant{" +
                "id=" + id +
                ", applicant_name='" + applicant_name + '\'' +
                ", application_date=" + application_date +
                ", job=" + job +
                '}';
    }
}
