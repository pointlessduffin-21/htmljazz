package com.abcjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcjobs.model.BulkEmail;

@Repository
public interface BulkEmailRepository extends JpaRepository<BulkEmail, Long> {

}
