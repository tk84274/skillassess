package com.exam.skillassess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.skillassess.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	public User findFirstByUsername(String username);

	public User findFirstByEmail(String email);

	public User findFirstByPhone(String phone);
	
}
