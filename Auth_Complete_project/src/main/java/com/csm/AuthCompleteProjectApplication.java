package com.csm;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.csm.model.Role;
import com.csm.model.User;
import com.csm.model.UserRole;
import com.csm.service.UserService;

@SpringBootApplication
public class AuthCompleteProjectApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(AuthCompleteProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
//		System.out.println("Starting Code...");
//		User user = new User();
//		user.setName("Shadab");
//		user.setEmail("s@gmail.com");
//		user.setUsername("shadab2");
//		user.setPassword("abc");
//		user.setFile("test.jpg");
//		
//		
//		Role role = new Role();
//		role.setId(45L);
//		role.setRoleName("ADMIN");
//		
//		Set<UserRole> roleSet = new HashSet<>();
//		
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role);
//		
//		roleSet.add(userRole);
//		User user1 = userService.saveUser(user, roleSet);
//		System.out.println(user1.getUsername());
	}

}



