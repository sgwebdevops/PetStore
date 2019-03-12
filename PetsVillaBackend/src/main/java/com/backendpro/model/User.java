package com.backendpro.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class User implements Serializable{

	@Id
	@Email(message="Kindly fill in the proper mail Id. May be you missed @ or .")
	@NotEmpty(message="Kindly fill in EmailId")
	private String emailId;
	
	@NotEmpty(message="Kindly fill in password")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	private boolean enabled;
	
	private String role;
	
	@NotEmpty(message="Kindly fill in your First Name")
	private String firstName;
	
	@NotEmpty(message="Kindly fill in your Last Name")
	private String lastName;
	/*private Address address;*/
	
	@NotEmpty(message="Kindly fill in the Mobile Number")
	@Size(min=10,max=10)
	private String mobileNumber;
	
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", Contact Number=" + mobileNumber + "]";
	}
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE,mappedBy="userObj")
	private Set<Address> addresses = new HashSet<>();



	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
}
