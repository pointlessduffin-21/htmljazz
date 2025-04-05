package com.mow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mow.entity.OrderRequest;

@Repository
public interface OrderRepository extends JpaRepository<OrderRequest, Long>{
	@Query("SELECT o FROM OrderRequest o WHERE o.member_id = :member_id")
    List<OrderRequest> findByMember_id(@Param("member_id") Long member_id);
}