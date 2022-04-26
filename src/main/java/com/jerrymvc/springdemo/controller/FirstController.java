package com.jerrymvc.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
	
	@RequestMapping("/")
	public String goSomeWhere() {
		return "index";
	}
	
//	@RequestMapping(value="/showform",method = RequestMethod.GET)
	@GetMapping(value="/showform")
	public String showForm() {
		return "student_form";
	}
	
	@GetMapping(value="/processForm")
	public String formAction(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentname");
		
		String result = "Hi: " + name + "!!";
		
		model.addAttribute("message", result);
		
		
		return "student";
	}
	
	@GetMapping(value="/processForm3")
	public String formAction3(@RequestParam("studentname") String theName, Model model) {
		String result = "Hi " + theName + "from processForm3";
		
		model.addAttribute("message", result);
		
		return "student3_response";
	}

}
