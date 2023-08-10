package com.exam.skillassess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.skillassess.entity.JwtRequest;
import com.exam.skillassess.entity.JwtResponse;
import com.exam.skillassess.service.impl.UserDetailsServiceImpl;

import config.JwtUtils;

@RestController
public class AuthenticationController {
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest request) throws Exception{
		
		try {
			authenticate(request.getUsername(), request.getPassword());
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found Exception");
		}
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));  
		}catch(DisabledException e) {
			throw new Exception("User Disabled" + e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Bad Credentials" + e.getMessage());
		}
	}
}
