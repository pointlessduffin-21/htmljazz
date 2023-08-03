package xyz.yeems214.abcjobs.Entity;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String creator;
    private String content;
    private String photoURL;
    private int likes;
    private LocalDateTime post_dateTime;


}
