package com.exam.skillassess.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	String authorityRole;
	
	public Authority(String authorityRole) {
		this.authorityRole = authorityRole;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authorityRole;
	}

}
