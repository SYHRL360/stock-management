package com.The360company.portfolio.inventorymanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.The360company.portfolio.inventorymanagement.entity.ProductIn;

public interface ProductInRepository extends JpaRepository<ProductIn, Integer> {

	// add a method to get all product in
	public List<ProductIn> findAll();
	
	@Query("select p.quantity from ProductIn p")
	public List<Integer> getAllQuantity();
	
}
