package com.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csm.model.Emp;
import com.csm.model.User;
import com.csm.service.EmpServiceImpl;
import com.csm.service.UserServiceImpl;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	@Autowired
	private EmpServiceImpl eService;

	@Autowired
	private UserServiceImpl uService;

	@RequestMapping("/")
	public String GetForm() {
		return "login";
	}
	
	@RequestMapping("/registerform")
	public String GetRegisterForm() {
		return "employee_registration";
	}

	@RequestMapping(path = "/saveEmp", method = RequestMethod.POST)
	public String SaveData(@ModelAttribute Emp emp,Model model) 
	{
		eService.save(emp);
		return "redirect:/registerform?success";
	}

	@RequestMapping(path = "/fetch",method = RequestMethod.GET)
	public String FetchData(@RequestParam("username") String username,
				@RequestParam("password") String password,Model model)
	{
			User user = uService.Find(username,password);
			System.out.println(user);
			if (user != null) {
				if (user.getRole().equals("admin")) {
				model.addAttribute("role", "admin");
				return "admin";
				} else if (user.getRole().equals("hr")) {
				model.addAttribute("role", "hr");
				return "admin";
				} else if (user.getRole().equals("employee")) {
				return "redirect:/registerform";
				}
			}
			return "redirect:/form";
	}
}
