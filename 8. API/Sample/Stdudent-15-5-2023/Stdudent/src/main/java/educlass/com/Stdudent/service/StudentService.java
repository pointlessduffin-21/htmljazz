package educlass.com.Stdudent.service;

import educlass.com.Stdudent.entity.Customer;
import java.util.List;



public interface StudentService  {
 void AddCustomer(Customer cust);
 void DeleteCustomer(Customer cust);
 List<Customer> showAllCustomers(); // Renamed method for clarity and corrected the return type
}