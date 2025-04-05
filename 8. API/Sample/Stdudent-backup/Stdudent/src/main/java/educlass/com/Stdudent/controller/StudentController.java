package educlass.com.Stdudent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import educlass.com.Stdudent.entity.Customer;
import educlass.com.Stdudent.service.StudentImp;



@Controller
public class StudentController {
	@Autowired
	StudentImp stservice;
	
	@GetMapping(value="/")
	public String showdetails()
	{
	return "index";
	}
	@GetMapping(value="/about")
	public String aboutdetails()
	{
	return "about";
	}
	@GetMapping(value="/admission")
	public String admissiondetails()
	{
	return "admission";
	}
	
//Contact us 	
	
	@GetMapping(value="/contact")
	public String contactdetails(@ModelAttribute("SCust") Customer c)
	{
	return "contact";
	}
	
	@PostMapping(value="/sendCustomer")
	public String SendCustomer(@ModelAttribute("SCust") Customer c)
	{
		stservice.AddCustomer(c);
		return "/";
	}
	
//end
	
	@GetMapping(value="/whyus")
	public String whyusdetails()
	{
	return "whyus";
	}
}
