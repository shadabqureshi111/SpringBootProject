package com.csm.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@org.springframework.stereotype.Controller
public class Controller 
{
	 
	@GetMapping("/html")
	public String hello(Model model)
	{
		model.addAttribute("msg", "HTML Page ");
		return "htmll";
	}
	
	@GetMapping("/jsp")
	public String helloo(Model model)
	{
		model.addAttribute("msg", "JSP Page ");
		return "jspp";
	}

}
