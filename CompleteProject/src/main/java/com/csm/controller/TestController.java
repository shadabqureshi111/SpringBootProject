package com.csm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	// it is used when we dont return any jsp page ,If we return String and you
	// want to show in web browser than you have to use @ResponseBody annotation
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		int a = 10;
		int b = 10;
		int c = 10;
		return "Sum of a and b = " + (a * b + c);
	}

}
