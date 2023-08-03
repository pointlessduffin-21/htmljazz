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

    public Thread() {
    }

    public Thread(String creator, String thread_title, String thread_content, int thread_likes, LocalDateTime thread_dateTime) {
        this.creator = creator;
        this.thread_title = thread_title;
        this.thread_content = thread_content;
        this.thread_likes = thread_likes;
        this.thread_dateTime = thread_dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public String getThread_title() {
        return thread_title;
    }

    public String getThread_content() {
        return thread_content;
    }

    public int getThread_likes() {
        return thread_likes;
    }

    public LocalDateTime getThread_dateTime() {
        return thread_dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setThread_title(String thread_title) {
        this.thread_title = thread_title;
    }

    public void setThread_content(String thread_content) {
        this.thread_content = thread_content;
    }

    public void setThread_likes(int thread_likes) {
        this.thread_likes = thread_likes;
    }

    public void setThread_dateTime(LocalDateTime thread_dateTime) {
        this.thread_dateTime = thread_dateTime;
    }

    @Override
    public String toString() {
        return "Thread{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", thread_title='" + thread_title + '\'' +
                ", thread_content='" + thread_content + '\'' +
                ", thread_likes=" + thread_likes +
                ", thread_dateTime=" + thread_dateTime +
                '}';
    }
}
