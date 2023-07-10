package com.exam.skillassess.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	  String activityStatus;
	
	@OneToMany(cascade = CascadeType.ALL, /*fetch = FetchType.EAGER */ mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> roles = new HashSet<>();
	
	public User() {
		
	}
	
	public Long getID() {
		return id;
	}
	public void setID(Long iD) {
		id = iD;
	}
	public String getUSERNAME() {
		return username;
	}
	public void setUSERNAME(String uSERNAME) {
		username = uSERNAME;
	}
	public String getPASSWORD() {
		return password;
	}
	public void setPASSWORD(String pASSWORD) {
		password = pASSWORD;
	}
	public String getEMAIL() {
		return email;
	}
	public void setEMAIL(String eMAIL) {
		email = eMAIL;
	}
	public String getPHONE() {
		return phone;
	}
	public void setPHONE(String pHONE) {
		phone = pHONE;
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
	public String getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	public User(Long iD, String uSERNAME, String pASSWORD, String fIRST_NAME, String lAST_NAME, String eMAIL,
			String pHONE, String aCTIVITY_STATUS) {
		super();
		id = iD;
		username = uSERNAME;
		password = pASSWORD;
		firstName = fIRST_NAME;
		lastName = lAST_NAME;
		email = eMAIL;
		phone = pHONE;
		activityStatus = aCTIVITY_STATUS;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", first_name=" + firstName
				+ ", last_name=" + lastName + ", email=" + email + ", phone=" + phone + ", activity_status="
				+ activityStatus + ", roles=" + roles + "]";
	}
	
}
