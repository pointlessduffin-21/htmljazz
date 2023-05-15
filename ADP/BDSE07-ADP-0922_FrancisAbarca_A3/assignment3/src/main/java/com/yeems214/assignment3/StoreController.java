package com.yeems214.assignment3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreController {
	
	@Autowired
	public StoreService s_Service;
	
	@GetMapping("/home")
	public String home() {
		return "redirect:/";
	}
	
	@GetMapping("addMoreStore")
	public String addMore() {
		return "redirect:addStore";
	}
	
	// Display AddStore form
	@RequestMapping(value="/CreateStore" , method=RequestMethod.GET)
	public String addStoreForm(Model model) {
		System.out.println("Create Store Info");
		model.addAttribute("store", new Store());
		return "createStore";
	}
	
	// Save the Store
	@RequestMapping(value="/saveStore", method=RequestMethod.POST)
	public String saveStore(Store store) {
		System.out.println("Save Store Info");
		Store savedStore = s_Service.saveStore(store);
		return "redirect:StoreManager";
	}
	
	// View all stores
	@RequestMapping(value="/StoreManager", method=RequestMethod.GET)
	public String viewStore(Model model) {
		System.out.println("Show all stores");
		List<Store> allStores = s_Service.listAllStore();
		System.out.println(allStores);
		model.addAttribute("all_Stores", allStores);
		return "storeManager";
	}

}
