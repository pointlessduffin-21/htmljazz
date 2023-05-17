package com.yeems214.xyzcars.Repository;

import com.yeems214.xyzcars.Entity.Cars;
import com.yeems214.xyzcars.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query("SELECT u from Users u WHERE user_name=:uname")
    public List<Users> searchByName(String uname);

    List<Users> showAll();

    Users findByUsername(String userName);
}