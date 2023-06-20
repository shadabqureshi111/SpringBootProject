package com.csm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.csm.model.User;
import com.csm.repository.UserRepo;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner 
{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setUsername("admin");
		user.setPassword(bCryptPasswordEncoder.encode("admin"));
		user.setRole("ROLE_ADMIN");
		userRepo.save(user);
		
		User user1 = new User();
		user1.setEmail("normal@gmail.com");
		user1.setUsername("normal");
		user1.setPassword(bCryptPasswordEncoder.encode("normal"));
		user1.setRole("ROLE_NORMAL");
		userRepo.save(user1);
		
	}

}
