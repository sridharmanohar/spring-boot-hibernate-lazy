package com.springhibernatelazy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springhibernatelazy.model.Product;
import com.springhibernatelazy.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepository;
	
	public void save(Product product) {
		System.out.println("=========Saving Product===========");
		productRepository.save(product);
	}
	
	public void showAllProducts() {
		System.out.println("=============Fetching all products from db=============");
		List<Product> productList = productRepository.findAll();
		productList.forEach(System.out::println);
	}
	
	public void deleteAll(){
		System.out.println("=========Deleting all===========");
		productRepository.deleteAll();
	}

}
