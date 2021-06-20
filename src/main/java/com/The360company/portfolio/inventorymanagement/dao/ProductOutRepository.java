package com.The360company.portfolio.inventorymanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.The360company.portfolio.inventorymanagement.entity.ProductOut;

public interface ProductOutRepository extends JpaRepository<ProductOut, Integer> {

	// add a method to get all product in
	public List<ProductOut> findAll();
	
	@Query("select p.quantity from ProductOut p")
	public List<Integer> getAllQuantity();
}
