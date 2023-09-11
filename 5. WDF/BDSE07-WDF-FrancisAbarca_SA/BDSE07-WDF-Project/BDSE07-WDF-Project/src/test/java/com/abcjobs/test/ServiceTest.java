package com.abcjobs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;

import com.abcjobs.config.WebConfig;
import com.abcjobs.model.BulkEmail;
import com.abcjobs.model.UserDetails;
import com.abcjobs.model.Users;
import com.abcjobs.repository.BulkEmailRepository;
import com.abcjobs.repository.UsersRepository;
import com.abcjobs.service.BulkEmailService;
import com.abcjobs.service.UserDetailsService;
import com.abcjobs.service.UsersService;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {WebConfig.class})
public class ServiceTest {
	@InjectMocks
	UsersService us;
	
	@InjectMocks
	BulkEmailService bes;
	
	@Mock
	UsersRepository repos;
	
	@Mock
	BulkEmailRepository br;
	
	@Mock
	JavaMailSender mailSender;
	
	@Test
	public void deleteTest() {
		boolean delete = us.deleteUserById(5L);
		assertTrue(delete);
	}
	
	@Test
	public void isUserExistTest() {
		Long id = 1L;
		assertNotNull(us.isUserExist(id));
	}
	
	@Test
	public void sendMail() {
		String subject = "Important !";
		String body = "not really...";
		String email = "bdse0622-022@learning.educlaas.com";
		
		assertTrue(bes.sendEmail(subject, body, email));
	}
}
