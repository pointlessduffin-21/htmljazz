package xyz.yeems214.abcjobs.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String creator;
    private String job_title;
    private String job_description;
    private String company_name;
    private String job_type;
    private int job_interested;
    private LocalDateTime job_creation;
    private int job_range;
    private String job_status;

    @OneToMany(mappedBy = "job")
    @JsonManagedReference
    private List<JobApplicant> applicants;

    public Jobs() {
    }

    public Jobs(String creator, String job_title, String job_description, String company_name, String job_type, int job_interested, LocalDateTime job_creation, int job_range, String job_status) {
        this.creator = creator;
        this.job_title = job_title;
        this.job_description = job_description;
        this.company_name = company_name;
        this.job_type = job_type;
        this.job_interested = job_interested;
        this.job_creation = job_creation;
        this.job_range = job_range;
        this.job_status = job_status;
    }

    public Long getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getJob_description() {
        return job_description;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getJob_type() {
        return job_type;
    }

    public int getJob_interested() {
        return job_interested;
    }

    public LocalDateTime getJob_creation() {
        return job_creation;
    }

    public int getJob_range() {
        return job_range;
    }

    public String getJob_status() {
        return job_status;
    }

    public List<JobApplicant> getApplicants() {
        return applicants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public void setJob_interested(int job_interested) {
        this.job_interested = job_interested;
    }

    public void setJob_creation(LocalDateTime job_creation) {
        this.job_creation = job_creation;
    }

    public void setJob_range(int job_range) {
        this.job_range = job_range;
    }

    public void setJob_status(String job_status) {
        this.job_status = job_status;
    }

    public void setApplicants(List<JobApplicant> applicants) {
        this.applicants = applicants;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", job_title='" + job_title + '\'' +
                ", job_description='" + job_description + '\'' +
                ", company_name='" + company_name + '\'' +
                ", job_type='" + job_type + '\'' +
                ", job_interested=" + job_interested +
                ", job_creation=" + job_creation +
                ", job_range=" + job_range +
                ", job_status='" + job_status + '\'' +
                ", applicants=" + applicants +
                '}';
    }
}

