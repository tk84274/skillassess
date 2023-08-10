package com.exam.skillassess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.skillassess.entity.User;
import com.exam.skillassess.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) throws Exception {
		try {
			//System.out.println(user.toString());
			return ResponseEntity.ok(this.userService.createUser(user));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user: " + e.getMessage()); 
		}
	}
	
	@GetMapping("/{username}")
	public User getUserDetails(@PathVariable String username) throws Exception {
			System.out.println(username);
			return this.userService.getUserDetails(username);
		
	}
}
