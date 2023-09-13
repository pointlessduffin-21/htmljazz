package xyz.yeems214.jumpstart.DTO;

public class UserProfileDTO {
	private String userName;
	private String phoneNumber;
	private String address;
	private String email;
	private String role;

	public UserProfileDTO() {
	}

	public UserProfileDTO(String userName, String phoneNumber, String address, String email,
			String role) {
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserProfileDTO [userName=" + userName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", email=" + email + ", role=" + role + "]";
	}
	
	

}