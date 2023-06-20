package com.csm.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csm.model.User;
import com.csm.repository.DeptRepository;
import com.csm.repository.UserRepository;

@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class Controller {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DeptRepository deptRepository;

	@GetMapping("/test")
	@ResponseBody
	public String testData()
	{
		return "Hey!! Welcome to Sajjanpur";
	}

	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<User> saveUser(@RequestBody User user) 
	{
		User save=null;
		try
			{
			 save = userRepository.save(user);
			return ResponseEntity.of(Optional.of(save));
			}
		catch (Exception e) 
			{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			} 
	}

	@GetMapping("/getall")
	@ResponseBody
	public List<User> getAllUser() 
	{
		// List<User> findAll = userRepository.findAll();
		// List<User> findAll = userRepository.getAllList();
		List<User> findAll = userRepository.getUserList();
		findAll.forEach(user -> System.out.println(user));
		return findAll;
	}

	@GetMapping("/getbyname")
	@ResponseBody
	public ResponseEntity<List<User>> getByName(@PathParam("fn") String fn) 
	{
		List<User> findByFirstName = userRepository.findByFirstName(fn);
		findByFirstName.forEach(firstname -> System.out.println(firstname));
		if(findByFirstName.size()==0)
		{
			/*
			 * The object of ResponseEntity Contain Status of Not_Found and Than this build
			 * method create a new Object and Than will be return
			 */
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	//Build method is used to create a object of ResponseEntity
		}
		return ResponseEntity.of(Optional.of(findByFirstName));
	}

}
