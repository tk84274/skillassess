package com.exam.skillassess.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userxrole")
public class UserRole {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long userxroleId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne
	private Role role;

	public UserRole() {
		super();
	}

	public Long getId() {
		return userxroleId;
	}

	public void setId(Long id) {
		this.userxroleId = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
