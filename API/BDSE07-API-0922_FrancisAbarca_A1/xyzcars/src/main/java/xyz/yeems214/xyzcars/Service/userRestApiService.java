package xyz.yeems214.xyzcars.Service;

import xyz.yeems214.xyzcars.Entity.Users;

import java.util.List;

public interface userRestApiService {
    void addUser(Users u);
    void deleteUser(Users u);
    List<Users> getAllUsers();
    List<Users> searchByName(String key);
    boolean userExists(String userName, String password);
}