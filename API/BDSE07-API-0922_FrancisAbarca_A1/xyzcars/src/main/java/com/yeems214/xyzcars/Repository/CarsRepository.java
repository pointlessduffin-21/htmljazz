package com.yeems214.xyzcars.Repository;

import com.yeems214.xyzcars.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars, Integer> {
    @Query("SELECT c from Cars c WHERE car_name=:cname")
    public List<Cars> searchByName(String cname);
}