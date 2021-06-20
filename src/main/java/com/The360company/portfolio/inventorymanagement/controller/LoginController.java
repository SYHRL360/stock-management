package com.The360company.portfolio.inventorymanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.The360company.portfolio.inventorymanagement.entity.Product;
import com.The360company.portfolio.inventorymanagement.entity.ProductIn;
import com.The360company.portfolio.inventorymanagement.entity.ProductOut;
import com.The360company.portfolio.inventorymanagement.service.ProductService;

@Controller
public class LoginController {

	private ProductService<Product> productService;
	
	private ProductService<ProductIn> productInService;
	
	private ProductService<ProductOut> productOutService;
	
	public LoginController(ProductService<Product> productService,
						   ProductService<ProductIn> productInService,
						   ProductService<ProductOut> productOutService) {
		
		this.productService = productService;
		this.productInService = productInService;
		this.productOutService = productOutService;
	}
	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "login-page";
	}
	
	@GetMapping("/dashboard")
	public String showDasboard(Model model) {
		
		Map<String, Integer> modelToAdd = new HashMap<>();
		modelToAdd.put("totalPriceProduct", this.productService.totalPrice());
		modelToAdd.put("totalPriceProductIn", this.productInService.totalPrice());
		modelToAdd.put("totalPriceProductOut", this.productOutService.totalPrice());
		
		modelToAdd.put("totalQuantityProduct", this.productService.totalQuantity());
		modelToAdd.put("totalQuantityProductIn", this.productInService.totalQuantity());
		modelToAdd.put("totalQuantityProductOut", this.productOutService.totalQuantity());
		
		
		// add to spring model
		model.addAllAttributes(modelToAdd);
		
		return "index";
	}
	
}
