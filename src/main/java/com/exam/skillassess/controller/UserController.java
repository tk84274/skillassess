package com.exam.skillassess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.skillassess.entity.User;
import com.exam.skillassess.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) throws Exception {
		
			return this.userService.createUser(user);
		
	}
	
	@GetMapping("/{username}")
	public User getUserDetails(@PathVariable String username) throws Exception {
			System.out.println(username);
			return this.userService.getUserDetails(username);
		
	}
}
