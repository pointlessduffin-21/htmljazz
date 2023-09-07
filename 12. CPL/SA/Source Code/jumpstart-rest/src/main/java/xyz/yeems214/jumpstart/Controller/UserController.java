package xyz.yeems214.jumpstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yeems214.jumpstart.Entity.Role;
import xyz.yeems214.jumpstart.Entity.User;
import xyz.yeems214.jumpstart.Repository.UserRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        Role role = new Role();
        role.setId(1L);
        user.setRegistrationDateTime(LocalDateTime.now());
        user.setRole_id(role); // Sets the role id of a newly created user as Customer
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encodes the password before saving it to the database
        User registered = userRepository.save(user);
        return new ResponseEntity<>(registered, HttpStatus.CREATED);
    }







}
