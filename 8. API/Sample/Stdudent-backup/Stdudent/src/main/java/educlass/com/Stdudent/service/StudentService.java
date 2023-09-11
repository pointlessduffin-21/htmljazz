package educlass.com.Stdudent.service;

import org.springframework.stereotype.Service;

import educlass.com.Stdudent.entity.Customer;


public interface StudentService  {
 void AddCustomer(Customer cust);
 void DeleteCustomer(Customer cust);
}
