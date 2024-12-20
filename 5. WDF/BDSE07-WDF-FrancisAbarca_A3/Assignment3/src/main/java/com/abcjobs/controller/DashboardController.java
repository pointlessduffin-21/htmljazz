package com.abcjobs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abcjobs.model.Educations;
import com.abcjobs.model.Experiences;
import com.abcjobs.model.UserDetails;
import com.abcjobs.service.EducationsService;
import com.abcjobs.service.ExperiencesService;
import com.abcjobs.service.UserDetailsService;

@Controller
public class DashboardController {

	@Autowired
	UserDetailsService ud;
	
	@Autowired
	EducationsService eds;
	
	@Autowired
	ExperiencesService exs;
	
	@RequestMapping(value="/dashboard") // Profile View
	public ModelAndView dashboard(HttpSession session, Model model) throws Exception {
		try {
			this.setModel(model, session);
			return new ModelAndView("dashboard/index");  
		} catch (Exception e) {
			System.out.println(e);
			String msg = "Login required";
			model.addAttribute("message", msg);
			return new ModelAndView("login/login");
		}
	}
	
	@RequestMapping(value = "/profile")	// Load Profile View
	public ModelAndView profile(HttpSession session, Model model) {
		try {
			this.setModel(model, session);
			return new ModelAndView("dashboard/profile");  
		} catch (Exception e) {
			System.out.println(e);
			String msg = "Login required";
			model.addAttribute("message", msg);
			return new ModelAndView("login/login");
		}
	}
	
	@RequestMapping(value="/update-profile") // Get Update Profile for user
	public ModelAndView updateProfile(Model model, HttpSession session) throws Exception {
		try {
			this.setModel(model, session);
			return new ModelAndView("dashboard/update-profile");  
		} catch (Exception e) {
			System.out.println(e);
			String msg = "Login required";
			model.addAttribute("message", msg);
			return new ModelAndView("login/login");
		}
	}
	
	@RequestMapping(value="/update-profile", method = RequestMethod.POST) // POST Update Profile to Database
	public String up(
			@ModelAttribute("profile") UserDetails userDetails,
			@RequestParam("position") String position, @RequestParam("startDateEX") String startDateEX, 
			@RequestParam("endDateEX") String endDateEX, @RequestParam("companyNameEX") String companyNameEX, 
			@RequestParam("intitutionName") String intitutionName, @RequestParam("startDateED") String startDateED, 
			@RequestParam("endDateED") String endDateED, @RequestParam("educationName") String educationName, 
			Experiences experiences, Educations educations,
			Model model, HttpSession session) {
		
		Long userDetailsId = Long.parseLong(String.valueOf(session.getAttribute("userId")));
		ud.updateProfile(userDetailsId, userDetails);
		
		if(position.equals("") || startDateEX.equals("") || endDateEX.equals("") || companyNameEX.equals("")) {
			System.out.println("Experiences Empty");
		} else {
			
			experiences.setPosition(position);
			experiences.setStartDate(startDateEX);
			experiences.setEndDate(endDateEX);
			experiences.setCompanyName(companyNameEX);
			experiences.setUserDetailsId(String.valueOf(userDetailsId));
			
			exs.addExperiences(experiences);
		}
		
		if(intitutionName.equals("") || startDateED.equals("") || endDateED.equals("") || educationName.equals("")) {
			System.out.println("Educations Empty");
		} else {
			educations.setEducationName(educationName);
			educations.setStartDate(startDateED);
			educations.setEndDate(endDateED);
			educations.setIntitutionName(intitutionName);
			educations.setUserDetailsId(String.valueOf(userDetailsId));
			
			eds.addEducations(educations);
		}
		
		this.setModel(model, session);
		
		String msg = "Profile has been updated";
		model.addAttribute("message", msg);
		return "dashboard/profile";
	}
	
	private void setModel(Model model, HttpSession session) {
		String userId = String.valueOf(session.getAttribute("userId"));
		String[] userDetails = ud.getDetailsById(userId).replaceAll("null", "-").split(",");
		String udID = userDetails[0];
		
		model.addAttribute("f", userDetails[1].charAt(0));
		model.addAttribute("l", userDetails[2].charAt(0));
		
		model.addAttribute("firstName", userDetails[1]);
		model.addAttribute("lastName", userDetails[2]);
		
		model.addAttribute("fullName", userDetails[1] + " " + userDetails[2]);
		model.addAttribute("title", userDetails[3]);
		model.addAttribute("about", userDetails[4]);
		model.addAttribute("company", userDetails[5]);
		model.addAttribute("email", session.getAttribute("email"));
		model.addAttribute("website", userDetails[6]);
		
		// experiences
		model.addAttribute("ex", exs.getExperiencesByUserDetailsId(udID)); // Experiences[]
		
		// educations
		model.addAttribute("ed", eds.getEducationsByUserDetailsId(udID)); // Educations[]
	}
}
