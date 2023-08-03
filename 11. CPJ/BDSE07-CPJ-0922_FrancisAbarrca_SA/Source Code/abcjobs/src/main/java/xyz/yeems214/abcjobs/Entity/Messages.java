package xyz.yeems214.abcjobs.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String sender;
    private String recipient;
    private String content;
    private LocalDateTime message_dateTime;


}
