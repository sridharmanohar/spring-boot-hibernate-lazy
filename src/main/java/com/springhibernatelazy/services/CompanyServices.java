package com.springhibernatelazy.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernatelazy.model.Company;
import com.springhibernatelazy.model.Employee;
import com.springhibernatelazy.repository.CompanyRepository;

@Service
public class CompanyServices {

	@Autowired
	CompanyRepository companyRepository;

	public void save(Company company) {
		System.out.println("=========Saving Company===========");
		companyRepository.save(company);
	}
	
	@Transactional	
	public void showAllCompanies() {
		long startTime = System.currentTimeMillis();
		List<Company> companyList = companyRepository.findAll();
		System.out.println("=========Fetching companies from db==============");
		for(Company company : companyList) {
			System.out.println(company.getName());
			for(Employee employee : company.getEmployees()) {
				System.out.println(employee.getName());
			}
		}
//		companyList.forEach(x -> {
//			System.out.println(x.getName());
//			x.getEmployees().forEach(y -> System.out.println(y.getName()));
//		});
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken:"+ (endTime - startTime));
	}

	public void deleteAll(){
		System.out.println("=========Deleting all===========");
		companyRepository.deleteAll();
	}
	
	
}
