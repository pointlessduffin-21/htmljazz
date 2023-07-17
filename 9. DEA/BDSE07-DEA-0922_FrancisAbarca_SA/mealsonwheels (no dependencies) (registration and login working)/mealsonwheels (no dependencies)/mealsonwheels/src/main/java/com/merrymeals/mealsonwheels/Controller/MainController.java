package com.merrymeals.mealsonwheels.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Service.MealService;
import com.merrymeals.mealsonwheels.Service.UserService;

@Controller
public class MainController {
	
	@Autowired
	MealService mealService;
	
	@Autowired
	UserService userService;

    @RequestMapping("/")
    public String landing() {
        return "Innnnndex";
    }

    @RequestMapping("/dashboard")
    public String homePage() {
        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        if (userService.loginUser(email, password)) {
            return "redirect:/member";
        } else {
            return "redirect:/login?error";
        }
    }

    @RequestMapping("/register")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("/contact")
    public String contactUsPage() {
        return "contact";
    }

    @RequestMapping("/about")
    public String aboutUsPage() {
        return "about";
    }
  
    @RequestMapping("/member")
    public String memberDashboard(@RequestParam(required = false) String searchKey, Model model) {
        if (searchKey != null && !searchKey.equals("")) {
            searchKey = searchKey.split(" ")[0];

            List<Meal> mealResult = mealService.searchByKey(searchKey);
			model.addAttribute("mealResult", mealResult);
			
			if(mealResult.size() == 0) {
				model.addAttribute("noMealResult", true);
			}
        }

        return "member";
    }

    @RequestMapping("/volunteer")
    public String volunteerDashboard() {
        return "volunteer";
    }
    
	/*
	 * @RequestMapping(value="/searchTwo") public List<Meal>
	 * searchMeal(@RequestParam String searchKey) { List<Meal> mealResult =
	 * mealService.searchByKey(searchKey); return mealResult; redirect "member"; }
	 */
    
    @RequestMapping(value="/search")
	public String search(@RequestParam String searchKey, Model model) throws Exception {
        
		if(searchKey != null && !searchKey.equals("")) {
			searchKey = searchKey.split(" ")[0];
			
			List<Meal> mealResult = mealService.searchByKey(searchKey);
			model.addAttribute("mealResult", mealResult);
			
			if(mealResult.size() == 0) {
				model.addAttribute("noMealResult", true);
			}
	    }
		
		return "redirect:/member";
		
	}

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/donator")
    public String donatePage() {
        return "donator";
    }

    @RequestMapping("/kitchen")
    public String kitPage() {
        return "kitchen";
    }
}
