package xyz.yeems214.kyn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import xyz.yeems214.kyn.Entity.Users;
import xyz.yeems214.kyn.Repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(Users u) {
        userRepository.save(u);
    }

    @Override
    public void deleteUser(Users u) {
        userRepository.delete(u);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> searchByName(String key) {
        return userRepository.search(key);
    }

    @Override
    public boolean userExists(String userName, String password) {
        Users u = userRepository.findByUserName(userName);
        if (u != null && u.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Create a new Spring Security User object with the user's details
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
