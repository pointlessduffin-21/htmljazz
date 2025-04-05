package com.yeems214.assignment5.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager; // import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yeems214.assignment5.entity.Store;
import com.yeems214.assignment5.entity.User;
import com.yeems214.assignment5.service.StoreService;
import com.yeems214.assignment5.service.UserService;

@Controller
public class StoreController {
    private static final Logger logger = LogManager.getLogger(StoreController.class);
    @Autowired
    public StoreService s_Service;
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String handleRootRequest() {

        return "redirect:home";
    }
    @GetMapping("home")
    public String homePage(Principal principal, Model model) {
        //Get User name
        String username = principal.getName();

        User user_data = userService.findLoginUser(username);
        List<User> user = new ArrayList<User>();
        user.add(user_data);

        model.addAttribute("user",user);

        return "index";
    }
    @PreAuthorize("hasRole('Administrator')")
    @GetMapping(value = "/addStore")
    public String addStoreForm(@ModelAttribute("store") Store store) {
        System.out.println("Add Store Form");

        return "addStore";
    }
    @PostMapping(value = "/saveStore")
    public String saveStore(@ModelAttribute("store") Store store, Model model, Principal principal) {
        logger.info("before calling Service to save store info");	// use for logging for tracing the errors and displaying
        System.out.println("Save Store information");
        //Get User name
        String username = principal.getName();

        User user = userService.findLoginUser(username);

        store.setEmail(user.getEmail());

        s_Service.saveStore(store);
        logger.info("After calling Service to save store info");

        String add_success = "store added successfully!";
        model.addAttribute("add_success", add_success);

        return "addStore";
    }
    @PreAuthorize("hasAnyRole('Users','Administrator')")
    @RequestMapping(value = "/viewStore", method = RequestMethod.GET)
    public ModelAndView viewStore(Model model) {
        logger.info("before calling Service to fetch all store details");
        System.out.println("List out all store");
        List<Store> allStores = s_Service.listAllStore();
        logger.info("after calling Service to fetch all store details");
        System.out.println(allStores);

        return new ModelAndView("storeList", "all_Stores", allStores);
    }
    @GetMapping("/update")
    public String updateStore(@ModelAttribute("store") Store store, @RequestParam long sid, Model model) {
        logger.info("before calling Service to fetch selected store detail for updating"); // use for logging for tracing the errors and displaying
        Optional<Store> store_info = s_Service.getStoreInfo(sid);
        System.out.println(store_info);
        model.addAttribute("id", store_info.get().getId());
        model.addAttribute("name", store_info.get().getName());
        model.addAttribute("phone_number", store_info.get().getPhone_number());
        model.addAttribute("localities", store_info.get().getLocalities());
        logger.info("after calling Service to update selected store detail under addStore method");	// use for logging for tracing the errors and displaying
        return "addStore";
    }
    @GetMapping("delete")
    public String deleteStore(@RequestParam long sid) {
        logger.info("before calling Service to delete store");	// use for logging for tracing the errors and displaying
        s_Service.deleteStore(sid);
        logger.info("after calling Service to delete store"); // use for logging for tracing the errors and displaying
        return "redirect:viewStore";
    }
    @GetMapping("search_store")
    public String searchStore(@RequestParam("keyword") String email, Model model) {
        logger.info("before calling Service to fetch store details by email");
        List<Store> search_result = s_Service.searchStore(email);
        System.out.println(search_result);
        logger.info("after calling Service to fetch store details by email");
        model.addAttribute("search_result", search_result);
        model.addAttribute("searchKey", email);

        return "searchResult";
    }

}