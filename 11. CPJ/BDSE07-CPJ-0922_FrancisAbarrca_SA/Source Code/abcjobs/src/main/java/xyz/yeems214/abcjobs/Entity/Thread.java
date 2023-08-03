package xyz.yeems214.abcjobs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String creator;
    private String thread_title;
    private String thread_content;
    private int thread_likes;
    private LocalDateTime thread_dateTime;


}
