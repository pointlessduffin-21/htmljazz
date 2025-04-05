package com.merrymeals.mealsonwheels.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long a_id;
	private String email;
	private String password;
	private String name;
	
	public Admin() {
		
	}
	
	
	
	public Admin(Long a_id, String email, String password, String name) {
		super();
		this.a_id = a_id;
		this.email = email;
		this.password = password;
		this.name = name;
	}



	public Long getA_id() {
		return a_id;
	}
	public void setA_id(Long a_id) {
		this.a_id = a_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Admin [a_id=" + a_id + ", email=" + email + ", password=" + password + ", name=" + name + "]";
	}

	
}
 