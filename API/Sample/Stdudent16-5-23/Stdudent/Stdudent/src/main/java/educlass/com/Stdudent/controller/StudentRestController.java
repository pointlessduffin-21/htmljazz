package educlass.com.Stdudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import educlass.com.Stdudent.entity.Customer;
import educlass.com.Stdudent.service.StudentImp;

@RestController
//@RequestMapping("/apiclass")
public class StudentRestController {
	@Autowired
	StudentImp stservice;
	
	@GetMapping("/testrest")
	public String testmethod()
	{
		return "hello";
	}
	
	//Add Records 
	
	 @PostMapping(value = "/addcustomer")
	    public String addProduct(@RequestBody Customer cust) 
	  {	    	
		 System.out.println(cust.getCustomerName());
		 stservice.AddCustomer(cust);
	    	return "Data Added";
	    }
	//show all the records
	 @GetMapping("/showcust")
		public List<Customer> showcust()
		{
			return stservice.ShowCustomer();
		}
	 //Serach by name
	//API http://localhost:9091/searchname?custname=Arvinderkkk
	 @GetMapping(value="/searchname")
	 public List<Customer> searchname(@RequestParam("custname") String cname)
	 {
		
		 return  stservice.SearchByName(cname);
	 }
	 
	
	
}
