package com.jerrymvc.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jerrymvc.springdemo.model.Employee;
import com.jerrymvc.springdemo.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/add")
	public String addEmployeePage(Model model) {
		
		model.addAttribute("employeeBean", new Employee());
		
		return "employee/addPage";
	}
	
	@PostMapping("/add")
	public String postEmployee(@ModelAttribute("employeeBean") Employee postEmp) {
		empService.addEmployee(postEmp);
		
		return "employee/addFinishPage";
	}
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		List<Employee> allEmployee = empService.getAllEmployee();
		
		model.addAttribute("employeeList", allEmployee);
		return "employee/listEmployee";
	}
	
	@GetMapping("/deleteEmp")
	public String deleteEmployee(@RequestParam("id") Integer id) {
		empService.deleteEmployee(id);
		
		// 去找 Controller 對應的 url -> servlet 中的 sendRedirect
		return "redirect:list";
	}
	
	

	@GetMapping("/editemployee")
	public String editEmployeePage(@RequestParam("id") Integer id, Model model) {
                                   //		/editemployee?id=x
		Employee tempEmp = empService.getEmployeeById(id);
		
		model.addAttribute("employeeBean", tempEmp);
		
		return "employee/editpage";
	}
	
	@GetMapping(path="/listjson",produces = "application/json")
	@ResponseBody
	public List<Employee> listEmployeeJson() {
		List<Employee> allEmployee = empService.getAllEmployee();
		
		
		return allEmployee;
	}
	
	
	

}
