package com.yeems214.abcarportal.service;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yeems214.abcarportal.model.User;
import com.yeems214.abcarportal.repository.RoleRepository;
import com.yeems214.abcarportal.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    RoleRepository roleRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /*

    @Test
    public void saveRegisterUserData() {
        User user = new User();
        user.setId((long) 1);
        user.setName("Jhonrey Inso");
        user.setUserName("jhonreyinso29");
        user.setEmail("jhoninso29@yeems214.xyz");
        String encodedPassword = passwordEncoder.encode("gwapoko214");
        user.setPassword(encodedPassword);
        user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles("Users")));
        Mockito.when(userRepository.save(user)).thenReturn(user);
        String userResponse = userService.save(user);
        Assert.assertEquals("User saved successfully", userResponse);
    }

     */


    @Test
    public void doesThisPersonExist() {
        User user = new User(); String
        username = "jhonreyinso29"; user.setUserName(username);
        Mockito.when(userRepository.findByUserName(username)).thenReturn(user);
        User loginUser = userService.findLoginUser(username);
        Assert.assertEquals(user, loginUser);
    }
}
