package com.yeems214.abcarportal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yeems214.abcarportal.model.Car;
import com.yeems214.abcarportal.model.CarBidding;
import com.yeems214.abcarportal.model.User;

@Repository
public interface BidRepository extends JpaRepository<CarBidding, Long>{

    List<CarBidding> findByUserAndCar(User user, Car car);

    List<CarBidding> findByUser(User user);

    @Query(value = "SELECT id FROM car_bidding WHERE car_id = :cid", nativeQuery = true)
    public Long[] getBidId(@Param("cid") Long cid);

}
