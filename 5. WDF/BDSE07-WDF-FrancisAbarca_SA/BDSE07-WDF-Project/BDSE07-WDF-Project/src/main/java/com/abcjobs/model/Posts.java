package com.abcjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Posts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long postId;
	
	@Column(name = "category_id")
	private String categoryId;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "heading")
	private String heading;
	
	@Column(name = "body")
	private String body;
	
	@Column(name = "created_at")
	private String createdAt;
	
	public Posts() {}
	public Posts(Long postId, String categoryId, String createdBy, String heading, String body, String createdAt) {
		this.postId = postId;
		this.categoryId = categoryId;
		this.createdBy = createdBy;
		this.heading = heading;
		this.body = body;
		this.createdAt = createdAt;
		
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
