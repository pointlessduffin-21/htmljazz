package xyz.yeems214.jumpstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import xyz.yeems214.jumpstart.DTO.JwtAuthenticationResponse;
import xyz.yeems214.jumpstart.DTO.LoginRequest;
import xyz.yeems214.jumpstart.Entity.Role;
import xyz.yeems214.jumpstart.Entity.User;
import xyz.yeems214.jumpstart.Exception.AppException;
import xyz.yeems214.jumpstart.Repository.UserRepository;
import xyz.yeems214.jumpstart.Repository.RoleRepository;
import xyz.yeems214.jumpstart.Security.JwtTokenProvider;
import xyz.yeems214.jumpstart.DTO.ApiResponse;


import xyz.yeems214.jumpstart.Entity.User;
import xyz.yeems214.jumpstart.Token.SessionToken;
import xyz.yeems214.jumpstart.Token.SessionTokenRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionTokenRepository sessionTokenRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

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
            user.setPassword(passwordEncoder.encode(user.getPassword())); // Encodes the password before saving it to the database
            User registered = userRepository.save(user);
            return new ResponseEntity<>(registered, HttpStatus.CREATED);
        }
    }

    @PostMapping("/loginOld")
        public ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpServletResponse response) {
            String email = credentials.get("email" );
            String password = credentials.get("password" );
            Optional<User> user = userRepository.findByEmail(email);
            if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
                // Login successful, create new session token
                SessionToken sessionToken = new SessionToken();
                sessionToken.setToken(UUID.randomUUID().toString());
                sessionToken.setExpirationDateTime(LocalDateTime.now().plusHours(1));
                sessionToken.setUser(user.get());
                sessionTokenRepository.save(sessionToken);

                // Create a new cookie with the session token and add it to the response
                Cookie cookie = new Cookie("session_token", sessionToken.getToken());
                response.addCookie(cookie);

                return ResponseEntity.ok().build();
            } else {
                // Login failed
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        String roleName = userDetails.getAuthorities().iterator().next().getAuthority(); // Retrieve the role name

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new AppException("User not found."));
        String userName = user.getUsername(); // Retrieve the first name
        Long userId = user.getId(); // Retrieve the user ID
        String email = username;
        String phoneNumber = String.valueOf(user.getPhoneNumber());
        String message = "User '" + username + "' logged in successfully.";

        JwtAuthenticationResponse response = new JwtAuthenticationResponse(jwt, message, roleName, userName, userId, email, phoneNumber);
        System.out.println("User ID: " + response.getUserId());

        return ResponseEntity.ok(response);
    }
}
