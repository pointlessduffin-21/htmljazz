package com.mow.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String email;
	private String name;
	private Double donated;
	private Long roleId;
	 private LocalDateTime donatedDate;
    public Donor() {
    	this.donatedDate = LocalDateTime.now();
    }
	public Donor(Long id, String email, String name, Double donated, Long roleId, LocalDateTime donatedDate) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.donated = donated;
		this.roleId = roleId;
		this.donatedDate = donatedDate;
	}
	@Override
	public String toString() {
		return "Donor [id=" + id + ", email=" + email + ", name=" + name + ", donated=" + donated + ", roleId=" + roleId
				+ ", donatedDate=" + donatedDate + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getDonated() {
		return donated;
	}
	public void setDonated(Double donated) {
		this.donated = donated;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public LocalDateTime getDonatedDate() {
		return donatedDate;
	}
	public void setDonatedDate(LocalDateTime donatedDate) {
		this.donatedDate = donatedDate;
	}
   
    
}
