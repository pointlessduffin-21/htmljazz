package educlass.com.Stdudent.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import educlass.com.Stdudent.entity.Customer;

public interface StudentRepo extends JpaRepository<Customer, Integer>{
	@Query("SELECT c from Customer c WHERE customer_Name=:cname")
	public List<Customer> searchByName(String cname);

}
