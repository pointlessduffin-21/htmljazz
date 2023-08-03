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

    public Messages() {
    }

    public Messages(String sender, String recipient, String content, LocalDateTime message_dateTime) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.message_dateTime = message_dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getMessage_dateTime() {
        return message_dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMessage_dateTime(LocalDateTime message_dateTime) {
        this.message_dateTime = message_dateTime;
    }


}
