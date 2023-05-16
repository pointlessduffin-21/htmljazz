package educlass.com.Stdudent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import educlass.com.Stdudent.entity.Customer;
import educlass.com.Stdudent.repos.StudentRepo;

@Service("StudentService")
public class StudentImp implements StudentService {
	@Autowired
	StudentRepo st;
	@Override
	public void AddCustomer(Customer cust) {
		
		st.save(cust);
		System.out.println("added");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DeleteCustomer(Customer cust) {
	st.delete(cust);
		
	}

}
