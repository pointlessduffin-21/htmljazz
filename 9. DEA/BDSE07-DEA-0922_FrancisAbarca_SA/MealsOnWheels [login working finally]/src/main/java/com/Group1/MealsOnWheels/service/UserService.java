package com.Group1.MealsOnWheels.service;

import com.Group1.MealsOnWheels.Entity.User;
import com.Group1.MealsOnWheels.repository.RoleRepository;
import com.Group1.MealsOnWheels.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String save(User user) {
        // Check if the username already exists in the database
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Username already exists";
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles("Users")));

        userRepository.save(user);

        return "User saved successfully";
    }


    public User findLoginUser(String username) {
        return userRepository.findByUserName(username);
    }

    public List<User> showAllUser(){

        return userRepository.findAll();
    }

    public void update(User user) {

        userRepository.save(user);

    }

    public String findRoleByUid(long uid) {
    	return userRepository.findRoleByUid(uid);
    }

    public List<User> listAllRider(){
		return userRepository.findUsersByRole("Volunteer");
	}

    public Optional<User> getUserInfo(long uid){

        return userRepository.findById(uid);

    }

    public void deleteUser(long uid) {

        userRepository.deleteById(uid);
    }

    public void assignNewRole(User user, String role) {

        user.getRoles().clear();
        user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles(role)));
        userRepository.save(user);
    }

    public void saveUser(User u, String r) {

        u.setRoles(new HashSet<>(roleRepository.findBySpecificRoles(r)));

        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);

        userRepository.save(u);

    }

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//	public Boolean loginUser(String email, String password) {
//		User logUser = ur.login(email, password);
//		if (logUser != null) {
//			return true;
//		}
//
//		return false;
//
//	}

    public User getUser(String email, String password) {
        return userRepository.loginUser(email, password);
    }

    public Boolean loginUser(String email, String password) {
        User logUser = userRepository.loginUser(email, password);
        if (logUser != null) {
            return true;
        }

        return false;
    }


// Partner

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public String findRoleByUid(Long Uid) {
        return userRepository.findRoleByUid(Uid);
    }

    public String findRoleIdByUid(Long Uid) {
        return userRepository.findRoleIdByUid(Uid);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        // TODO Auto-generated method stub
        return userRepository.findByEmail(email);
    }

}
