package xyz.yeems214.abcjobs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String creator;
    private String comment_content;
    private int comment_likes;
    private LocalDateTime comment_dateTime;

    public Comment() {
    }

    public Comment(String creator, String comment_content, int comment_likes, LocalDateTime comment_dateTime) {
        this.creator = creator;
        this.comment_content = comment_content;
        this.comment_likes = comment_likes;
        this.comment_dateTime = comment_dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public String getComment_content() {
        return comment_content;
    }

    public int getComment_likes() {
        return comment_likes;
    }

    public LocalDateTime getComment_dateTime() {
        return comment_dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public void setComment_likes(int comment_likes) {
        this.comment_likes = comment_likes;
    }

    public void setComment_dateTime(LocalDateTime comment_dateTime) {
        this.comment_dateTime = comment_dateTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", comment_content='" + comment_content + '\'' +
                ", comment_likes=" + comment_likes +
                ", comment_dateTime=" + comment_dateTime +
                '}';
    }
}
