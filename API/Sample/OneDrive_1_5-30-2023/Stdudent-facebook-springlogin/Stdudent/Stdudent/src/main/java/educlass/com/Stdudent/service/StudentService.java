package educlass.com.Stdudent.service;

import java.util.List;

import org.springframework.stereotype.Service;


import educlass.com.Stdudent.entity.Customer;


public interface StudentService  {
 void AddCustomer(Customer cust);
 void DeleteCustomer(Customer cust);
 public List<Customer> ShowCustomer();
 public List<Customer> SearchByName(String cname);
 
}
