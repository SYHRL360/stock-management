package com.The360company.portfolio.inventorymanagement.service;

import java.util.List;

import com.The360company.portfolio.inventorymanagement.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(int id);
	
	public void save(Product product);
	
	public void deleteById(int id);
	
	public List<Product> searchBy(String name);
	
}
