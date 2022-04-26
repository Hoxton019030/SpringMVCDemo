package com.jerrymvc.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jerrymvc.springdemo.model.Car;

@Controller
public class CarController {
	
	@GetMapping("/showCarForm")
	public String showCarForm(Model model) {
		
		model.addAttribute("carBean", new Car());
		
		return "car-form";
	}
	
	@PostMapping("/carAction")
	public String formAction(@ModelAttribute("carBean") Car car, Model model) {
		
		System.out.println("car brand: " + car.getBrand());
		
		return "car-response";
	}

}
