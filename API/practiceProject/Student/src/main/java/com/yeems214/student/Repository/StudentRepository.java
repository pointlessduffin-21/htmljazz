package com.yeems214.student.Repository;

import com.yeems214.student.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Customer, Long>{

}