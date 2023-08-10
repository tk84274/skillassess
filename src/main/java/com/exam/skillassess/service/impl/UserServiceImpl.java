package com.exam.skillassess.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.skillassess.entity.User;
import com.exam.skillassess.entity.UserRole;
import com.exam.skillassess.repo.RoleRepository;
import com.exam.skillassess.repo.UserRepository;
import com.exam.skillassess.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) throws Exception {
		
		//System.out.println(user.toString());
		User userName, email, phone;
		try {
			userName = this.userRepository.findFirstByUsername(user.getUsername());
			email = this.userRepository.findFirstByEmail(user.getEMAIL());
			phone = this.userRepository.findFirstByPhone(user.getPHONE());
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Exception occured while fetching user data.");
		}
		
		
		User registeredUser;
		
		if(userName!=null) {
			throw new Exception("User Already exists with this username");
		}else if(email!=null) {
			throw new Exception("User Already exists with this email id");
		}else if(phone!=null) {
			throw new Exception("User Already exists with this phone no");
		}else{
			
			user.setActivityStatus("30");
			
			registeredUser = this.userRepository.save(user);
		}
		
		return registeredUser;
	}

	@Override
	public User getUserDetails(String username) {
		return this.userRepository.findFirstByUsername(username)==null ? new User() : this.userRepository.findFirstByUsername(username);
	}

}
