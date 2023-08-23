package com.abcjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcjobs.model.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
	
}
