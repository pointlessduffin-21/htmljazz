package xyz.yeems214.kyn.Service;

import xyz.yeems214.kyn.Entity.Users;

import java.util.List;

public interface userRestApiService {
    void addUser(Users u);
    void deleteUser(Users u);

    void deleteById(Integer id);

    void deleteUser(Integer id);

    List<Users> getAllUsers();
    List<Users> searchByName(String key);
    boolean userExists(String userName, String password);
}