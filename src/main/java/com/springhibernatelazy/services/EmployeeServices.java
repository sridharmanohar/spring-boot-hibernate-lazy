package com.springhibernatelazy.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springhibernatelazy.model.Employee;
import com.springhibernatelazy.repository.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void save(Employee employee) {
		System.out.println("=========Saving Employee===========");
		employeeRepository.save(employee);
	}
	
	public void showAllEmployees() {
		System.out.println("=============Fetching all employees from db=============");
		List<Employee> employeeList = employeeRepository.findAll();
		employeeList.forEach(System.out::println);
	}
	
	public void deleteAll(){
		System.out.println("=========Deleting all===========");
		employeeRepository.deleteAll();
	}
	
	
}
