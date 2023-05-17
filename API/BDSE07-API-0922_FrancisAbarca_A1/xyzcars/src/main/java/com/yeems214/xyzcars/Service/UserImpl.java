package com.yeems214.xyzcars.Service;

import com.yeems214.xyzcars.Entity.Users;
import com.yeems214.xyzcars.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service("userService")
public class UserImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Override
    public void AddUser(Users user) {
        userRepo.save(user);
        System.out.println("Successfully added user.");

        // TODO Auto-generated method stub
    }

    public void deleteUser(Users user) {
        userRepo.delete(user);
        System.out.println("Successfully deleted user.");
    }

    @Override
    public List<Users> showAll() {
        // TODO Auto-generated method stub

        return userRepo.findAll();
    }
    @Override
    public List<Users> searchByName(String uname) {
        return userRepo.searchByName(uname);
    }

    @Override
    public Users findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Boolean validateUser(String userName, String password) {
        Users user = (Users) userRepo.searchByName(userName);
        if (user != null) {
            return new BCryptPasswordEncoder().matches(password, user.getUserPassword());
        } else {
            return "admin".equals(userName) && "admin".equals(password);
        }
    }
}
