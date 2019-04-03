package com.springhibernatelazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springhibernatelazy.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
