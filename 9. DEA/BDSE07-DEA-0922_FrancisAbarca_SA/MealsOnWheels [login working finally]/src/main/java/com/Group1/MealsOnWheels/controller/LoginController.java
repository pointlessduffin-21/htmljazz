package com.Group1.MealsOnWheels.controller;

import com.Group1.MealsOnWheels.Entity.User;
import com.Group1.MealsOnWheels.repository.UserRepository;
import com.Group1.MealsOnWheels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("login")
    public String onLogin() {
        return "login";
    }


    @GetMapping("login_error")
    public String onLoginError(Model model) {
        String error_msg = "Incorrect username or password. Try Again.";
        model.addAttribute("error_string", error_msg);
        System.out.println(error_msg);
        return "login";
    }

    @PostMapping("/register_user")
    public String registration(User user, @RequestParam("userRole") String role) {
        userService.saveUser(user,role);
        return "login" ;

    }

    @GetMapping("login_success")
    public String loginSuccess(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails loggedUser = (UserDetails) authentication.getPrincipal();
            session.setAttribute("user", loggedUser);

            //Get user by username
            User user = userService.findByUserName(loggedUser.getUsername());
            String roleName = userService.findRoleByUid(user.getId());
            //GetRoleByUserId
            // If role is Administrator redirect adminpage
            if (roleName.equals("Administrator")) {
                System.out.println("User has logged in as: " + loggedUser.getUsername());
            	return "redirect:/admin";
            } else if (roleName.equals("Member")) {
                System.out.println("User has logged in as: " + loggedUser.getUsername());
                return "redirect:/member";
            } else if (roleName.equals("Partner")) {
                System.out.println("User has logged in as: " + loggedUser.getUsername());
                return "redirect:/kitchen";
            } else if (roleName.equals("Volunteer")) {
                System.out.println("User has logged in as: " + loggedUser.getUsername());
                return "redirect:/volunteer";
            } else if (roleName.equals("Donator")) {
                System.out.println("User has logged in as: " + loggedUser.getUsername());
                return "redirect:/donator";
            } else
                return "redirect:/login_error";
        } else
            return "redirect:/login_error";
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "testy";
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//        System.out.println("User has logged out.");
//    	return "login";
//    }

}
