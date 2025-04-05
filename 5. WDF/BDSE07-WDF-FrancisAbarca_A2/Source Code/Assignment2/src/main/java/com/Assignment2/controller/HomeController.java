package com.Assignment2.controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Assignment2.bean.User;

@Controller
public class HomeController {
	private String[] users = {"James - Software Engineer", "Surya - DevOps", "Adi - QA", "Nico - Database Management", "Oswin - Software Engineer"};
	private String[] about = {"Hi there!", "I am a Professional"};
	private String[] company = {"Trunyx", "Plajo", "Google", "Meta", "Microsoft", "Lithan"};
	private String[] website = {"Google.com", "Microsoft.com", "-"};
	
	@RequestMapping(value="/") // home page
	public ModelAndView index(HttpServletResponse res) throws Exception {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/home") // home page
	public ModelAndView home(Model model) throws Exception {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/registration")
	public ModelAndView registration(HttpServletResponse res) throws Exception {
		return new ModelAndView("registration"); 
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public String registration(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("emailAddress") String email, @RequestParam("password") String password, Model model) throws Exception {
		User.setEmail(email);
		User.setPassword(password);
		User.setfN(firstName);
		User.setlN(lastName);
		model.addAttribute("email", email);
		return "thankyou";
	}
	
	@RequestMapping(value="/thankyou")
	public ModelAndView thankyou(HttpServletResponse res) throws Exception {
		return new ModelAndView("thankyou"); 
	}
	
	@RequestMapping(value="/verified")
	public ModelAndView verified() throws Exception {
		return new ModelAndView("verified"); 
	}
	
	@RequestMapping(value="/verificationcode")
	public ModelAndView verificationcode() throws Exception {
		return new ModelAndView("verificationcode"); 
	}
	
	@RequestMapping(value="/verificationcode", method = RequestMethod.POST)
	public String verificationcode(@RequestParam("code") Integer vCode) throws Exception {
		if (vCode==1234) {
			return "verified";  // Run the Verified String
		} else {
			return "thankyou";  // Return to this very String
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletResponse res, Model model) throws Exception {
		model.addAttribute("e", User.getEmail());
		model.addAttribute("p", User.getPassword());
		return new ModelAndView("login"); 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST) // login process
	public String login(@RequestParam("emailAddress") String email, @RequestParam("password") String password, Model model) throws Exception {
		if(email.toLowerCase().equals(User.getEmail().toLowerCase()) && password.equals(User.getPassword())) {
			this.setModel(model);
			User.setIsLogin(true);
			return "dashboard";
		}
		
		String msg = "Incorrect Credentials!";
		model.addAttribute("message", msg);
		return "login";
	}
	
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletResponse res, Model model) throws Exception {
		User.setfN(null);
		User.setlN(null);
		User.setTitle(null);
		User.setAbout(null);
		User.setCompany(null);
		User.setWebsite(null);
		User.setEmail(null);
		User.setPassword(null);
		
		String[] experiences = {null};
		User.setExperiences(experiences);
		String[] educations = {null};
		User.setEducations(educations);
		User.setIsLogin(false);
		return "login"; 
	}
	
	@RequestMapping(value="/forgot-password")
	public ModelAndView forgotPassword(HttpServletResponse res) throws Exception {
		return new ModelAndView("forgot-password");  
	}
	
	@RequestMapping(value="/forgot-password", method = RequestMethod.POST) // forgot password logic
	public String forgotPassword(@RequestParam("emailAddress") String email, Model model) throws Exception {
		
		try {
			if(email.toLowerCase().equals(User.getEmail().toLowerCase())) {
				User.setIsReset(true);
				return "reset-password";
			}
		} catch (Exception e) {
			System.out.println(email + " " + e);
		}
				
		String msg = "Email not found";
		model.addAttribute("message", msg);
		return "forgot-password";
	}
	
	@RequestMapping(value="/reset")
	public ModelAndView reset(Model model) throws Exception {
		if(User.isReset()) {
			return new ModelAndView("reset-password");  
		}
		String msg = "Email required";
		model.addAttribute("message", msg);
		return new ModelAndView("forgot-password"); 
	}
	
	@RequestMapping(value="/reset", method = RequestMethod.POST) // reset password
	public String reset(@RequestParam("password") String password, Model model) throws Exception {
		User.setPassword(password);
		String msg = "Password has been changed";
		model.addAttribute("scMessage", msg);
		return "login";
	}
	
	@RequestMapping(value="/dashboard") // profile overview
	public ModelAndView dashboard(Model model) throws Exception {
		try {
			this.setModel(model);
			return new ModelAndView("dashboard");  
		} catch (Exception e) {
			String msg = "Login required";
			model.addAttribute("message", msg);
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="/profile") // update profile GET
	public ModelAndView profile(Model model) throws Exception {
		try {
			this.setModel(model);
			return new ModelAndView("profile"); 
		} catch (Exception e) {
			String msg = "Login required";
			model.addAttribute("message", msg);
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="/profile", method = RequestMethod.POST) // update profile POST
	public String up(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("title") String title, @RequestParam("about") String about, @RequestParam("position") String position, @RequestParam("startDateEX") String startDateEX, @RequestParam("endDateEX") String endDateEX, @RequestParam("companyName") String companyName, @RequestParam("intitutionName") String intitutionName, @RequestParam("startDateED") String startDateED, @RequestParam("endDateED") String endDateED, @RequestParam("educationName") String educationName, @RequestParam("company") String company, @RequestParam("website") String website, Model model) {
		User.setfN(firstName);
		User.setlN(lastName);
		User.setTitle(title);
		User.setAbout(about);
		User.setCompany(company);
		User.setWebsite(website);
		
		if(position.equals("") || startDateEX.equals("") || endDateEX.equals("") || companyName.equals("")) {
			System.out.println("Cannot be empty");
		} else {
			String[] experiences = {position, startDateEX, endDateEX, companyName};
			User.setExperiences(experiences);
		}
		
		if(intitutionName.equals("") || startDateED.equals("") || endDateED.equals("") || educationName.equals("")) {
			System.out.println("Cannot be empty");
		} else {
			String[] educations = {intitutionName, startDateED, endDateED, educationName};
			User.setEducations(educations);
		}
		
		this.setModel(model);
		
		String msg = "Profile has been updated";
		model.addAttribute("message", msg);
		return "dashboard";
	}
	
	@RequestMapping(value="/search")
	public ModelAndView search(HttpServletRequest req, Model model) throws Exception {
		String q = req.getParameter("q");
		ArrayList<String> selectedUser = new ArrayList();
		
		if(q != null && !q.equals("")) {
			Pattern p = Pattern.compile("[" + q.toLowerCase() + "]");
			
			for(String u: this.users) {
				String user = u.split("-")[0].toLowerCase();
				Matcher m = p.matcher(user);
				
				if(m.find(0)) {
					selectedUser.add(u);
				}
			}
		} 
		
		if(selectedUser.size() == 0 && q != null) {
			model.addAttribute("notFound", true);
		} else {
			model.addAttribute("selected", selectedUser);
		}
		
		return new ModelAndView("search");  
	}
	
	@RequestMapping(value="/result", method = RequestMethod.POST) // view someone profile
	public ModelAndView searchProfile(@RequestParam("name") String name, Model model) throws Exception {
		int about = new Random().nextInt(this.about.length);
		int company = new Random().nextInt(this.company.length);
		int website = new Random().nextInt(this.website.length);
		
		for(String u: this.users) {
			String userName = u.split("-")[0];
			
			if(name.equals(userName)) {
				
				model.addAttribute("f", userName.charAt(0));
				model.addAttribute("l", "");
				
				model.addAttribute("firstName", userName);
				model.addAttribute("lastName", "");
				
				model.addAttribute("fullName", userName + " " + "");
				model.addAttribute("title", u.split("-")[1]);
				model.addAttribute("about", this.about[about]);
				model.addAttribute("company", this.company[company]);
				model.addAttribute("email", userName + "@gmail.com");
				model.addAttribute("website", this.website[website]);
				  
				String[][] ex = {{u.split("-")[1], "2012", "2022", this.company[company]}};
				model.addAttribute("ex", ex);
				
				String[][] ed = {{"University", "2010", "2014", "MIT"}};
				model.addAttribute("ed", ed);
				
			}
		}
		return new ModelAndView("result");  
	}
	
	private void setModel(Model model) {
		model.addAttribute("f", User.getFN().charAt(0));
		model.addAttribute("l", User.getLN().charAt(0));
		
		model.addAttribute("firstName", User.getFN());
		model.addAttribute("lastName", User.getLN());
		
		model.addAttribute("fullName", User.getFN() + " " + User.getLN());
		model.addAttribute("title", User.getTitle());
		model.addAttribute("about", User.getAbout());
		model.addAttribute("company", User.getCompany());
		model.addAttribute("email", User.getEmail());
		model.addAttribute("website", User.getWebsite());
		
		// experiences
		model.addAttribute("ex", User.getExperiences());
		
		// educations
		model.addAttribute("ed", User.getEducations());
	}
}
