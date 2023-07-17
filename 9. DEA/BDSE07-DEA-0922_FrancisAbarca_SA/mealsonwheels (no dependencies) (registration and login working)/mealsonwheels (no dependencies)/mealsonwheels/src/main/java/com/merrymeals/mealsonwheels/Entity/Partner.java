package com.merrymeals.mealsonwheels.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long p_id;
	private String email;
	private String password;
	private String name;
	private String address;
	private String contact;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User volunteer;

	
	public Partner() {
		
	}
	
	
	
	public Partner(Long p_id, String email, String password, String name, String address, String contact,
			User volunteer) {
		super();
		this.p_id = p_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.volunteer = volunteer;
	}



	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public User getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(User volunteer) {
		this.volunteer = volunteer;
	}



	@Override
	public String toString() {
		return "Partner [p_id=" + p_id + ", email=" + email + ", password=" + password + ", name=" + name + ", address="
				+ address + ", contact=" + contact + ", volunteer=" + volunteer + "]";
	}
	
	
}
