package com.The360company.portfolio.inventorymanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.The360company.portfolio.inventorymanagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	// add a method to get all product
	public List<Product> findAll();
	
	// search by name
	public List<Product> findByProductNameContainsAllIgnoreCase(String productName);
}
