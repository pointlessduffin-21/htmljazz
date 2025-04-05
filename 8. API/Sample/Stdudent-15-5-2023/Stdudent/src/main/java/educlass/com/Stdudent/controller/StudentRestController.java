package educlass.com.Stdudent.controller;

import educlass.com.Stdudent.entity.Customer;
import educlass.com.Stdudent.repos.StudentRepo;
import educlass.com.Stdudent.service.StudentImp;
import educlass.com.Stdudent.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {
	StudentImp stservice;

	@GetMapping("/testrest")
	public String testmethod()
	{
		return "hello";
	}

	// Add Records
	@PostMapping(value = "/customer")
	public String addProduct(@RequestBody Customer cust) {
		stservice.AddCustomer(cust);
		return "Customer added successfully";
	}

	// Show all Records
	@GetMapping("/showcust")
	public List<Customer> showcust() {
		return stservice.showAllCustomers();
	}

}
