package com.springhibernatelazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springhibernatelazy.model.Company;
import com.springhibernatelazy.model.Employee;
import com.springhibernatelazy.model.Product;
import com.springhibernatelazy.services.CompanyServices;
import com.springhibernatelazy.services.EmployeeServices;
import com.springhibernatelazy.services.ProductServices;

@SpringBootApplication
public class SpringHibernatefetchType implements CommandLineRunner {

	@Autowired
	CompanyServices companyService;
	
	@Autowired
	ProductServices productService;

	@Autowired
	EmployeeServices employeeServices;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringHibernatefetchType.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		clearData();
//		saveData();
		showData();
	}

    private void clearData(){
    	System.out.println("=================== Clear DATA =======================");
    	companyService.deleteAll();
        productService.deleteAll();
        employeeServices.deleteAll();
    }
    
    private void saveData(){
    	System.out.println("=================== Save DATA =======================");
    	Product iphone7 = new Product("Iphone 7");
        Product iPadPro = new Product("IPadPro");
        
        Product galaxyJ7 = new Product("GalaxyJ7");
        Product galaxyTabA = new Product("GalaxyTabA");

        Employee empApple1 = new Employee("AppEmp1");
        Employee empApple2 = new Employee("AppEmp2");
        
        Employee empSamsung1 = new Employee("SamEmp1");
        Employee empSamsung2 = new Employee("SamEmp2");

        Company apple = new Company("Apple");
        Company samsung = new Company("Samsung");
        
        // set company for products
        iphone7.setCompany(apple);
        iPadPro.setCompany(apple);
        
        galaxyJ7.setCompany(samsung);
        galaxyTabA.setCompany(samsung);
        
        // set company for employees
        empApple1.setCompany(apple);
        empApple2.setCompany(apple);
        
        empSamsung1.setCompany(samsung);
        empSamsung2.setCompany(samsung);
        
        // save companies
        companyService.save(apple);
        companyService.save(samsung);
         
        // save products
        productService.save(iphone7);
        productService.save(iPadPro);
        
        productService.save(galaxyJ7);
        productService.save(galaxyTabA);
        
        // save employees
        employeeServices.save(empApple1);
        employeeServices.save(empApple2);
        
        employeeServices.save(empSamsung1);
        employeeServices.save(empSamsung2);
    }
    
    private void showData(){
    	System.out.println("=================== Show ALL Data =======================");
        companyService.showAllCompanies();
//        productService.showAllProducts();
//        employeeServices.showAllEmployees();
    }
	
	
	
	
}
