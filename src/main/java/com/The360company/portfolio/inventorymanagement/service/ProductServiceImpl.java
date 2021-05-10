package com.The360company.portfolio.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.The360company.portfolio.inventorymanagement.dao.ProductRepository;
import com.The360company.portfolio.inventorymanagement.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository theProductRepository) {
		this.productRepository = theProductRepository;
	}
	
	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product findById(int id) {
		
		Optional<Product> result = this.productRepository.findById(id);
		
		Product theProduct = null;
		
		if(result.isPresent()) {
			theProduct = result.get();
		} else {
			// we didn't find the product
			throw new RuntimeException("Did not find product id -" + id);
		}
		
		return theProduct;
	}

	@Override
	public void save(Product product) {
		this.productRepository.save(product);
	}

	@Override
	public void deleteById(int id) {
		this.productRepository.deleteById(id);
	}

	@Override
	public List<Product> searchBy(String name) {
	
		List<Product> result = null;
		
		if(name != null && (name.trim().length() > 0)) {
			result = this.productRepository.findByProductNameContainsAllIgnoreCase(name);
		} else {
			result = findAll();
		}
		
		return result;
	}

	
}
