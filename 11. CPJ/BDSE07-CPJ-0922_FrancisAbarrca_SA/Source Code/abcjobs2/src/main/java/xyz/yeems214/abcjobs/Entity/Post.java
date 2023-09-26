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

    public Post() {
    }

    public Post(String creator, String content, String photoURL, int likes, LocalDateTime post_dateTime) {
        this.creator = creator;
        this.content = content;
        this.photoURL = photoURL;
        this.likes = likes;
        this.post_dateTime = post_dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public String getContent() {
        return content;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public int getLikes() {
        return likes;
    }

    public LocalDateTime getPost_dateTime() {
        return post_dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setPost_dateTime(LocalDateTime post_dateTime) {
        this.post_dateTime = post_dateTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", content='" + content + '\'' +
                ", photoURL='" + photoURL + '\'' +
                ", likes=" + likes +
                ", post_dateTime=" + post_dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return getId().equals(post.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
