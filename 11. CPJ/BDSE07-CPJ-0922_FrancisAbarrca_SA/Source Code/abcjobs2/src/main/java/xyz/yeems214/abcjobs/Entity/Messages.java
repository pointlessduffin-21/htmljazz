package xyz.yeems214.abcjobs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String sender;
    private String recipient;
    private String content;
    private LocalDateTime message_dateTime;
    private boolean isRead;

    public Messages() {
    }

    public Messages(String sender, String recipient, String content, LocalDateTime message_dateTime, boolean isRead) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.message_dateTime = message_dateTime;
        this.isRead = isRead;
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

    public boolean isRead() {
        return isRead;
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

    public void setRead(boolean read) {
        isRead = read;
    }
    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", content='" + content + '\'' +
                ", message_dateTime=" + message_dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Messages)) return false;
        Messages messages = (Messages) o;
        return getId().equals(messages.getId()) &&
                getSender().equals(messages.getSender()) &&
                getRecipient().equals(messages.getRecipient()) &&
                getContent().equals(messages.getContent()) &&
                getMessage_dateTime().equals(messages.getMessage_dateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSender(), getRecipient(), getContent(), getMessage_dateTime());
    }
}
