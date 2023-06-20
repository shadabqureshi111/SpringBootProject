package com.csm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.csm.dao.UserRepository;
import com.csm.helper.Message;
import com.csm.model.User;

@org.springframework.stereotype.Controller
public class Controller 
{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/")
	public String Home(Model model)
	{
		model.addAttribute("title","Home - Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String About(Model model)
	{
		model.addAttribute("title","About - Smart Contact Manager");
		return "about";
	}
	
	@GetMapping("/register")
	public String Signup(Model model)
	{
		model.addAttribute("title","Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	// handler for registering user
	
	@RequestMapping(path = "/do_register",method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1,
			@RequestParam(value="agreement",defaultValue = "false") Boolean agreement ,
			Model model,
			HttpSession session)
	{
		try 
		{
			if(!agreement)
			{
				System.out.println("You have not agreed the terms and condition");
				throw new Exception("You have not agreed the terms and condition");
			}
			
			if(result1.hasErrors())
			{
				System.out.println("Error"+result1.toString());
				model.addAttribute("user",user);
				return "signup";
			}
			user.setRole("ROE_USER");
			user.setEnable(true);
			user.setImageUrl("default.png");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			System.out.println("Agreement "+agreement);
			System.out.println("User "+user);
			
			User result = this.userRepository.save(user);
			
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered","alert-success"));
			return "redirect:./register";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something wrong!"+ e.getMessage(),"alert-danger"));
			return "signup";
		}
		
	}
	
}
