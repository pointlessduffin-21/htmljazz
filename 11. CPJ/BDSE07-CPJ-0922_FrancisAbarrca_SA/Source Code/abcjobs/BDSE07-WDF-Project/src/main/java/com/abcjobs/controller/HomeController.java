package com.abcjobs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value="/") // home page
	public ModelAndView index() {
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value="/home") // home page
	public ModelAndView home(HttpServletResponse res, HttpServletRequest req, 
			@CookieValue(value = "email", defaultValue = "") String email,
			@CookieValue(value = "userId", defaultValue = "") String userId,
			HttpSession session) {
		
		if(!email.equals("")) {
			// add session
			session.setAttribute("email", email);
			session.setAttribute("userId", userId);
			session.setAttribute("isLogin", true);
		}
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/thankyou")
	public ModelAndView thankyou(HttpServletResponse res) throws Exception {
		return new ModelAndView("registration/thankyou"); 
	}
	
	@RequestMapping(value="/verified")
	public ModelAndView verified() throws Exception {
		return new ModelAndView("registration/verified"); 
	}
	
	@RequestMapping(value="/verificationcode")
	public ModelAndView verificationcode() {
	    return new ModelAndView("registration/verificationcode");
	}
	
	@RequestMapping(value="/verificationcode", method = RequestMethod.POST)
	public String verificationcode(@RequestParam("code") Integer vCode, Model model) {
	    if (vCode==1234) {
	        return "redirect:/verified";
	    } else {
	        model.addAttribute("message", "Incorrect verification code.");
	        return "verificationcode";
	    }
	}
}
