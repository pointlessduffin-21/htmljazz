package com.yeems214.student.Service;

import com.yeems214.student.Entity.Customer;
import com.yeems214.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class StudentImplementation implements StudentService {
    @Autowired
    StudentRepository studentRepo;

    @Override
    public void AddCustomer(Customer customer) {
        studentRepo.save(customer);
        System.out.println("Customer added!");
    }

    @Override
    public void DeleteCustomer(Customer customer) {
        studentRepo.delete(customer);
    }
}
