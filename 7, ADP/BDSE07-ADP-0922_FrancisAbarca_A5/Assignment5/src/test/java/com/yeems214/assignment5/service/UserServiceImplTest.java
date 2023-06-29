package com.yeems214.assignment5.service;

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

import com.yeems214.assignment5.entity.User;
import com.yeems214.assignment5.repository.RoleRepository;
import com.yeems214.assignment5.repository.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    RoleRepository roleRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setId((long) 1);
        user.setUserName("test");
        String encodedPassword = passwordEncoder.encode("123456");
        user.setPassword(encodedPassword);
        user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles("Users")));
        Mockito.when(userRepository.save(user)).thenReturn(user);
        String userResponse = userService.saveUser(user);
        Assert.assertEquals("User saved successfully", userResponse);
    }


}
