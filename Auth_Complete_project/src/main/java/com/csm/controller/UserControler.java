//package com.csm.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.csm.model.User;
//import com.csm.service.UserService;
//
//@RestController
//@RequestMapping("/user")
//public class UserControler {
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//
//	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}
//
//	@PostMapping("/save")
//	public ResponseEntity<User> saveData(@Valid @RequestBody User user) throws Exception {
//		String encodedPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//		System.out.println(encodedPassword);
//		User report = null;
//		if (user == null) {
//			throw new Exception("User Can not be null");
//		} else {
//			report = userService.saveUser(user);
//		}
//		return new ResponseEntity<>(report, HttpStatus.CREATED);
//
//	}
//}





package com.csm.controller;

import com.csm.model.Role;
import com.csm.model.User;
import com.csm.model.UserRole;
import com.csm.service.UserService;
import com.csm.service.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserControler {

	@Autowired
	private UserService userService;

 
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) throws Exception 
    {
    	
//        User savedUser = userService.saveUser(user);
//        System.out.println(savedUser.getPassword());
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    	
    	Set<UserRole> roles = new HashSet<>();
    	Role role = new Role();
    	role.setId(1L);
    	role.setRoleName("NORMAL");
    	
    	UserRole userRole = new UserRole();
    	userRole.setUser(user);
    	userRole.setRole(role);
    	
    	roles.add(userRole);
    	System.out.println(user.getName());
    	System.out.println(user.getUsername());
    	System.out.println(user.getEmail());
    	System.out.println(user.getPassword());
    	System.out.println(user.getUserRole());
    	
    	return userService.saveUser(user,roles);
    }
    
    @GetMapping("/login")
    public User getLogin(@pathvari)
    {
    	System.out.println("Username = "+user.getUsername());
    	System.out.println("Password = "+user.getPassword());
    	return null;
    }
    
    @GetMapping("/{username}")
    public User GetUser(@PathVariable("username") String username) throws Exception
    {
    	return userService.GetUserById(username);	
    }
    
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id)
    {
    	userService.deleteUserById(id);
    	System.out.println("Deleted");
    }
}
