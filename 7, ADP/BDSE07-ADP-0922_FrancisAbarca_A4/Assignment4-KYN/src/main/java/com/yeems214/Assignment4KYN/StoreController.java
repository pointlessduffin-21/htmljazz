package com.yeems214.Assignment4KYN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {
    @Autowired
    public StoreService s_Service;

    @GetMapping("/home")
    public String home() {
        return "index";
    }
    @GetMapping(value="/addStore")
    public String addStoreForm(@ModelAttribute("store") Store store) {
        System.out.println("Add Store Form");
        return "addStore";
    }
    @PostMapping(value="/saveStore")
    public String saveStore(@ModelAttribute("store") Store store) {
        System.out.println("Save Store information");
        s_Service.saveStore(store);
        return "redirect:viewStore";
    }
    @RequestMapping(value="/viewStore", method=RequestMethod.GET)
    public ModelAndView viewStore(Model model) {
        System.out.println("List out all store");
        List<Store> allStores = s_Service.listAllStore();
        System.out.println(allStores);
        return new ModelAndView("storeList", "all_Stores",allStores);
    }
    @GetMapping("/update")
    public String updateStore(@ModelAttribute("store") Store store, @RequestParam long sid, Model model) {
        Optional<Store> store_info = s_Service.getStoreInfo(sid);
        System.out.println(store_info);
        model.addAttribute("id", store_info.get().getId());
        model.addAttribute("name", store_info.get().getName());
        model.addAttribute("phone_number",store_info.get().getPhone_number());
        model.addAttribute("localities",store_info.get().getLocalities());
        return "addStore";
    }
    @GetMapping("delete")
    public String deleteStore(@RequestParam long sid) {
        s_Service.deleteStore(sid);
        return "redirect:viewStore";
    }

}