package xyz.yeems214.kyn.Service;

import xyz.yeems214.kyn.Entity.User;

import java.util.List;

public interface UserService {
    void addUser(User u);
    void deleteUser(User u);

    void deleteById(Integer id);

    void deleteUser(Integer id);

    List<User> getAllUsers();
    List<User> searchByName(String key);
    boolean userExists(String userName, String password);
}