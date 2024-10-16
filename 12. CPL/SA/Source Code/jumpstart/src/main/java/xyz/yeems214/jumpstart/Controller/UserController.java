package xyz.yeems214.jumpstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yeems214.jumpstart.Entity.Role;
import xyz.yeems214.jumpstart.Entity.User;
import xyz.yeems214.jumpstart.Repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Check if a user with the same username already exists
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            // If a user is found, return a ResponseEntity with an appropriate message
            return new ResponseEntity<>("A user with this username already exists.", HttpStatus.BAD_REQUEST);
        } else {
            Role role = new Role();
            role.setId(1L);
            user.setRegistrationDateTime(LocalDateTime.now());
            user.setRole_id(role); // Sets the role id of a newly created user as Customer
            User registered = userRepository.save(user);
            return new ResponseEntity<>(registered, HttpStatus.CREATED);
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpServletResponse response) {
//        String email = credentials.get("email" );
//        String password = credentials.get("password" );
//        Optional<User> user = userRepository.findByEmail(email);
////        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
////            // Login successful, create new session token
////            SessionToken sessionToken = new SessionToken();
////            sessionToken.setToken(UUID.randomUUID().toString());
////            sessionToken.setExpirationDateTime(LocalDateTime.now().plusHours(1));
////            sessionToken.setUser(user.get());
////            sessionTokenRepository.save(sessionToken);
////
////            // Create a new cookie with the session token and add it to the response
////            Cookie cookie = new Cookie("session_token", sessionToken.getToken());
////            response.addCookie(cookie);
//
//            return ResponseEntity.ok().build();
//        } else {
//            // Login failed
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
}