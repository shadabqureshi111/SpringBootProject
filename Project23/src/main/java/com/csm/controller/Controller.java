package com.csm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csm.model.Roles;
import com.csm.model.Users;
import com.csm.repository.RolesRepository;
import com.csm.repository.UserRepository;

@RestController
@RequestMapping("/enroll")
@CrossOrigin
public class Controller {
//	@Autowired
//	private LoginRepository lr;
//	@Autowired
//	private RegisterRepository rr;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolesRepository rr;

	@RequestMapping(path = "/fetchUserType", method = RequestMethod.GET)
	public List<Roles> FetchUserType() {
		List<Roles> findUsertype = rr.findAll();
		return findUsertype;
	}

	// Save Data
//	@RequestMapping(path = "/register",method = RequestMethod.POST)
//	public ResponseEntity<Register> Register(@Valid @RequestBody Register registerData)
//	{
//		System.out.println(registerData);
//		Register saveData = rr.save(registerData);
//		return new ResponseEntity<>(registerData,HttpStatus.CREATED);
//	}

	// Login Method
//	@RequestMapping(path = "/login/{username}/{password}",method = RequestMethod.GET)
//	 public ResponseEntity<?>login(@PathVariable("username") String username,
//					    @PathVariable("password") String password ) throws ResourceNotFoundException
//	{
//		Map<String, Object> details = new HashMap<>();
//		Register r= rr.findByUsernameAndPassword(username,password);
//		String jwtToken="";
//		//String message="success";
//	    jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
//	    // Map<String, String> jwtTokenGen = new HashMap<>();
//	    if(r.getUsername().equals(username)) 
//		{
//			 details.put("token", jwtToken);
//			 details.put("message", "Logged-in");
//		}
//
//		else
//		{
//			  details.put("message","Wrong Credential");
//		}
//		return ResponseEntity.ok(details);
//		//new ResponseEntity<>(jwtGenerator.generateToken(Register), HttpStatus.OK);
//		
//	}

	
	@PostMapping("/rollback")
	public ResponseEntity<?> Register(@Valid @RequestBody Users users) {
		users.setEnable(1L);
		System.out.println(users);
		//users.setRoles(users.getRoles());
		userRepository.save(users);
		Map<String, Object> details = new HashMap<>();
		if(users!=null)
		{
		Users user = userRepository.save(users);
		details.put("message", "Successfull submit");
		}
		else
		{
			details.put("message", "Something Wrong");
		}
		return new ResponseEntity<>(users, HttpStatus.CREATED);
//		return null;
	}

}
