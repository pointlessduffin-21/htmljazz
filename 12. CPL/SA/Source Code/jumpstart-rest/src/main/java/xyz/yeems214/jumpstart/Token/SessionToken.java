package xyz.yeems214.jumpstart.Token;

import com.sun.istack.NotNull;
import xyz.yeems214.jumpstart.Entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SessionToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String token;
    @NotNull
    private LocalDateTime expirationDateTime;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SessionToken() {
    }

    public SessionToken(String token, LocalDateTime expirationDateTime, User user) {
        this.token = token;
        this.expirationDateTime = expirationDateTime;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

public String getToken() {
        return token;
    }

public LocalDateTime getExpirationDateTime() {
        return expirationDateTime;
    }

public User getUser() {
        return user;
    }

public void setId(Long id) {
        this.id = id;
    }

public void setToken(String token) {
        this.token = token;
    }

public void setExpirationDateTime(LocalDateTime expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

public void setUser(User user) {
        this.user = user;
    }
}
