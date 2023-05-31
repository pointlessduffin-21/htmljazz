package xyz.yeems214.kyn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.yeems214.kyn.Entity.User;
import xyz.yeems214.kyn.Repository.UserRepository;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User u) {
        userRepository.save(u);
    }

    @Override
    public void deleteUser(User u) {
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> searchByName(String key) {
        return userRepository.search(key);
    }

    @Override
    public boolean userExists(String userName, String password) {
        User u = userRepository.findByUserName(userName);
        if (u != null && u.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}