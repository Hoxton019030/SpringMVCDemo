package com.jerrymvc.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerrymvc.springdemo.model.Employee;
import com.jerrymvc.springdemo.model.EmployeeDao;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	public Employee addEmployee(Employee emp) {
		return empDao.insertEmp(emp);
	}
	
	public List<Employee> getAllEmployee() {
		return empDao.listEmp();
	}
	
	public boolean deleteEmployee(Integer id) {
		return empDao.delete(id);
	}
	
	public Employee updateEmployee(Employee emp) {
		return empDao.update(emp);
	}
	
	public Employee getEmployeeById(Integer id) {
		return empDao.findById(id);
	}
}
