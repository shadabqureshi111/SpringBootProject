package com.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csm.model.User;
import com.csm.service.UserService;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class Controller 
{
	@Autowired
	private UserService userService;
	
	// all users
	@GetMapping("/")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	//return single user
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userService.getUser(username);
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user)
	{
		return userService.adduser(user);
	}
}
