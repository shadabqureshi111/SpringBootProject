package com.csm.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@PreAuthorize("hasRole('NORMAL')")
public class HomeController 
{
	
	@GetMapping("/home")
	public String Home()
	{
		return "this is home page";
	}
	
	@GetMapping("/login")
	public String Login()
	{
		return "this is  login page";
	}

}
