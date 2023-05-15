package educlass.com.Stdudent.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import educlass.com.Stdudent.entity.Customer;

public interface StudentRepo extends JpaRepository<Customer, Long>{

}
