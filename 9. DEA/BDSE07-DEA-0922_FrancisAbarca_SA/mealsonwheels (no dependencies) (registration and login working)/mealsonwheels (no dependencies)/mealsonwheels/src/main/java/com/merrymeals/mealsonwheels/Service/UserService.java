package com.merrymeals.mealsonwheels.Service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Repsoitory.UserRepository;
import com.merrymeals.mealsonwheels.Repsoitory.RoleRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	public UserRepository ur;
	
	@Autowired
	public RoleRepository rs;
	
	
	
	
	public void saveUser(User u, String r) {
		
		u.setRoles(new HashSet<>(rs.findBySpecificRoles(r)));
		ur.save(u);
	}
	
	public User getUser(Long id) {
		return ur.findById(id).get();
	}
	
	public void deleteUser(Long id) {
		ur.deleteById(id);
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
	
	public Boolean loginUser(String email, String password) {
	    User logUser = ur.login(email, password);
	    return logUser != null;
	}

}
