package com.The360company.portfolio.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.The360company.portfolio.inventorymanagement.dao.ProductOutRepository;
import com.The360company.portfolio.inventorymanagement.entity.ProductOut;

@Service
public class ProductOutServiceImpl implements ProductService<ProductOut>, ProductUpdate<ProductOut> {

	
	private ProductOutRepository productOutRepository;
	
	@Autowired
	public ProductOutServiceImpl(ProductOutRepository productOutRepository) {
		this.productOutRepository = productOutRepository;
	}
	
	@Override
	public List<ProductOut> findAll() {
		return this.productOutRepository.findAll();
	}

	@Override
	public ProductOut findById(int id) {
		Optional<ProductOut> result = this.productOutRepository.findById(id);
		
		ProductOut theProductOut = null;
		
		if(result.isPresent()) {
			theProductOut = result.get();
		}else {
			// we didn't find the product
			throw new RuntimeException("Did not find product id - " + id);
		}
		
		return theProductOut;
	}

	@Override
	public void save(ProductOut productOut) {
		
		int updateQuantity = productOut.getProduct().getQuantity() - productOut.getQuantity();
	
		productOut.getProduct().setQuantity(updateQuantity);
	
		this.productOutRepository.save(productOut);
	} 

	
	@Override
	public void deleteById(int id) {
		
		ProductOut tempProductOut = this.findById(id);
		
		int updateQuantity = tempProductOut.getProduct().getQuantity() + tempProductOut.getQuantity();
		
		tempProductOut.getProduct().setQuantity(updateQuantity);
		
		this.productOutRepository.deleteById(id);
	}

	@Override
	public int totalPrice() {
	
		List<ProductOut> productOutList = this.findAll();
		
		int total = 0;
		
		for(ProductOut productOut : productOutList) {
			total += productOut.getSubtotal();
		}
		
		return total;
	}
	
	@Override
	public void update(ProductOut productOut) {
		ProductOut productOutFromDB = this.findById(productOut.getId());
		
		int differenceQuantity = 0;
		
		int adjustQuantity = 0;
		
		if(productOut.getQuantity() > productOutFromDB.getQuantity()) {
			differenceQuantity = productOut.getQuantity() - productOutFromDB.getQuantity();
			adjustQuantity = productOutFromDB.getProduct().getQuantity() - differenceQuantity;
		
		}else if(productOut.getQuantity() < productOutFromDB.getQuantity()) {
			differenceQuantity = productOutFromDB.getQuantity() - productOut.getQuantity();
			adjustQuantity = productOutFromDB.getProduct().getQuantity() + differenceQuantity;

		}		
		
		productOutFromDB.getProduct().setQuantity(adjustQuantity);

		this.productOutRepository.save(productOut);
	}

	@Override
	public int totalQuantity() {
		
		List<Integer> listQauntity = this.productOutRepository.getAllQuantity();

		int total = 0;

		for (Integer quantity : listQauntity) {
			total += quantity;
		}
		
		return total;
	}

}
