package com.The360company.portfolio.inventorymanagement.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.The360company.portfolio.inventorymanagement.validation.FieldMatch;
import com.The360company.portfolio.inventorymanagement.validation.ValidEmail;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class UserRegister {

	@NotNull(message = "harus diisi")
	@Size(min = 1, message = "harus disisi")
	private String userName;
	
	@NotNull(message = "harus diisi")
	@Size(min = 1, message = "harus diisi")
	private String password;
	
	@NotNull(message = "harus diisi")
	@Size(min = 1, message = "harus diisi")
	private String matchingPassword;
	
	@NotNull(message = "harus diisi")
	@Size(min = 1, message = "harus diisi")
	private String firstName;
	
	@NotNull(message = "harus diisi")
	@Size(min = 1, message = "harus diisi")
	private String lastName;
	
	@ValidEmail
	@NotNull(message = "harus diisi")
	@Size(min = 1, message = "harus diisi")
	private String email;
	
	public UserRegister() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
