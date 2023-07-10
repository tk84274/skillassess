package com.exam.skillassess.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.skillassess.entity.User;
import com.exam.skillassess.entity.UserRole;

@Service
public interface UserService {
	
	public User createUser(User user) throws Exception;

	public User getUserDetails(String username);
	
}
