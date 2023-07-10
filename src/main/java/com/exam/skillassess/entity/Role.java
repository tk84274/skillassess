package com.exam.skillassess.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL, /*fetch = FetchType.LAZY,*/ mappedBy = "role")
	private Set<UserRole> users = new HashSet<>();
	
	public Long getROLE_ID() {
		return id;
	}
	public void setROLE_ID(Long rOLE_ID) {
		id = rOLE_ID;
	}
	public String getROLE_NAME() {
		return roleName;
	}
	public void setROLE_NAME(String rOLE_NAME) {
		roleName = rOLE_NAME;
	}
	public Role(Long rOLE_ID, String rOLE_NAME) {
		super();
		id = rOLE_ID;
		roleName = rOLE_NAME;
	}
	
}
