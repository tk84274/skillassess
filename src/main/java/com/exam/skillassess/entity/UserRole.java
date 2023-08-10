package com.exam.skillassess.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
