package com.jerrymvc.springdemo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private SessionFactory factory;
	
	public Employee insertEmp(Employee emp) {
		Session session = factory.getCurrentSession();
		
		session.save(emp);
		
		return emp;
	}
	
	public List<Employee> listEmp(){
		Session session = factory.getCurrentSession();
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		List<Employee> resultList = query.getResultList();
		
		return resultList;
	}
	
	public boolean delete(Integer id) {
		Session session = factory.getCurrentSession();
		
		Employee tempEmp = session.get(Employee.class, id);
		
		if(tempEmp!=null) {
			session.delete(tempEmp);
			return true;
		}
		
		return false;
		
	}
	
	public Employee update(Employee emp) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(emp);
		return emp;
	}
	
	public Employee findById(Integer id) {
		Session session = factory.getCurrentSession();
		Employee tempEmp = session.get(Employee.class, id);
		return tempEmp;
	}

}
