package com.The360company.portfolio.inventorymanagement.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.The360company.portfolio.inventorymanagement.dao.ProductInRepository;
import com.The360company.portfolio.inventorymanagement.entity.ProductIn;

@Service
public class ProductInServiceImpl implements ProductService<ProductIn>, ProductUpdate<ProductIn> {

	private ProductInRepository productInRepository;
	
	@Autowired
	public ProductInServiceImpl(ProductInRepository productInRepository) {
		this.productInRepository = productInRepository;
	}

	@Override
	public List<ProductIn> findAll() {
		return this.productInRepository.findAll();
	}

	@Override
	public ProductIn findById(int id) {
		
		Optional<ProductIn> result = this.productInRepository.findById(id);
		
		ProductIn theProductIn = null;
		
		if(result.isPresent()) {
			theProductIn = result.get();
		} else {
			// we didn't find the product
			throw new RuntimeException("Did not find product id -" + id);
		}
		
		return theProductIn;
	}

	@Override
	public void save(ProductIn productIn) {
		
		int updateQuantity = productIn.getProduct().getQuantity() + productIn.getQuantity();
		
		productIn.getProduct().setQuantity(updateQuantity);
		
		this.productInRepository.save(productIn);
	}

	@Override
	public void deleteById(int id) {
		
		ProductIn tempProductIn = this.findById(id);
		
		int updateQuantity = tempProductIn.getProduct().getQuantity() - tempProductIn.getQuantity();
		
		tempProductIn.getProduct().setQuantity(updateQuantity);
		
		this.productInRepository.deleteById(id);
	}

	@Override
	public int totalPrice() {
		
		List<ProductIn> productInList = this.findAll();
		
		int total = 0;
		
		for(ProductIn productIn : productInList) {
			total += productIn.getSubtotal();
		}
		
		return total;
	}

	@Override
	public void update(ProductIn productIn) {
		
		ProductIn productInFromDB = this.findById(productIn.getId());
		
		int differenceQuantity = 0;
		
		int adjustQuantity = 0;
		
		if(productIn.getQuantity() > productInFromDB.getQuantity()) {
			differenceQuantity = productIn.getQuantity() - productInFromDB.getQuantity();
			adjustQuantity = productInFromDB.getProduct().getQuantity() + differenceQuantity;
		
		}else if (productIn.getQuantity() < productInFromDB.getQuantity()) {
			differenceQuantity = productInFromDB.getQuantity() - productIn.getQuantity();
			adjustQuantity = productInFromDB.getProduct().getQuantity() - differenceQuantity;
		}
		
		productInFromDB.getProduct().setQuantity(adjustQuantity);
		
		this.productInRepository.save(productIn);
	}

	@Override
	public int totalQuantity() {
		List<Integer> listQauntity = this.productInRepository.getAllQuantity();

		int total = 0;

		for (Integer quantity : listQauntity) {
			total += quantity;
		}
		
		return total;
	}
	
}
