package xyz.yeems214.jumpstart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yeems214.jumpstart.Entity.User;
import xyz.yeems214.jumpstart.Repository.UserRepository;
import xyz.yeems214.jumpstart.Token.SessionToken;
import xyz.yeems214.jumpstart.Token.SessionTokenRepository;

import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionTokenRepository sessionTokenRepository;

    public Optional<SessionToken> authenticate(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            SessionToken sessionToken = new SessionToken();
            sessionToken.setToken(UUID.randomUUID().toString());
            sessionToken.setExpirationDateTime(LocalDateTime.now().plusHours(1));
            sessionToken.setUser(user.get());
            return Optional.of(sessionTokenRepository.save(sessionToken));
        } else {
            return Optional.empty();
        }
    }
}
