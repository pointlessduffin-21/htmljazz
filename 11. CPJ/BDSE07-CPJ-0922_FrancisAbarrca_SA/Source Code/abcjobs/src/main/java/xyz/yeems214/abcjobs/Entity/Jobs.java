package xyz.yeems214.abcjobs.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.time.LocalDateTime;

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
    private String job_created;
    private int job_interested;
    private LocalDateTime job_creation;

    

}
