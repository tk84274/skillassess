package com.exam.skillassess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.skillassess.controller.UserController;
import com.exam.skillassess.entity.User;
import com.exam.skillassess.repo.UserRepository;

@SpringBootApplication
public class SkillassessApplication implements ApplicationRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserController userController;
	
	public static void main(String[] args) {
		SpringApplication.run(SkillassessApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		User user = new User(null, "tarun84274", "Hare Krishna4#", "Tarun", "Kumar", "tk84274@gmail.com", "123456", "30");
//		this.userController.register(user);
	}

}
