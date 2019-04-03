package com.springhibernatelazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springhibernatelazy.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
}
