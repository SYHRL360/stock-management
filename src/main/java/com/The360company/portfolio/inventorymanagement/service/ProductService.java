package com.The360company.portfolio.inventorymanagement.service;

import java.util.List;

public interface ProductService<T> {
	
	public List<T> findAll();
	
	public T findById(int id);
	
	public void save(T product);
	
	public void deleteById(int id);
	
 // public List<Product> searchBy(String name);
	
	public int totalQuantity();
	
	public int totalPrice();
	
}
