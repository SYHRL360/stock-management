package com.The360company.portfolio.inventorymanagement.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.The360company.portfolio.inventorymanagement.entity.Product;
import com.The360company.portfolio.inventorymanagement.entity.ProductIn;
import com.The360company.portfolio.inventorymanagement.service.ProductService;
import com.The360company.portfolio.inventorymanagement.service.ProductUpdate;

@Controller
@RequestMapping("/products-in")
public class ProductInController {

	private ProductService<Product> productService;
	
	private ProductService<ProductIn> productInService;
	
	private ProductUpdate<ProductIn> productInUpdate;
	
	public ProductInController(ProductService<Product> productService, 
							   ProductService<ProductIn> productInService,
							   ProductUpdate<ProductIn> productInUpdate) {
		this.productService = productService;
		this.productInService = productInService;
		this.productInUpdate = productInUpdate;
	}
	
	@GetMapping("/list")
	public String productInList(Model model) {
		
		List<ProductIn> productInList = this.productInService.findAll();
		
		int totalPriceProduct = this.productInService.totalPrice();
		
		// add to spring model
		model.addAttribute("productInList", productInList);
		
		model.addAttribute("totalPriceProduct", totalPriceProduct);
				
		return "/products/product-in";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("productInId") int id,
						     Model model) {
		List<Product> productList = this.productService.findAll();
		
		// get the productIn from the service
		ProductIn productInUpdate = this.productInService.findById(id);
		
		List<Product> searchProduct = productList
									  .stream()
									  .filter(p -> p.getProductName().equals(productInUpdate.getProduct().getProductName()))
									  .collect(Collectors.toList());
									  
		
		// send productIn as a model attribute to pre-populate the page
		model.addAttribute("productIn",productInUpdate);
		
		model.addAttribute("productList", searchProduct);
		// send over to our page
		return "/products/form-productin";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		List<Product> productList = this.productService.findAll();
		
		// create model attribute to bind form data
		ProductIn productIn = new ProductIn();
		
		model.addAttribute("productIn", productIn);
		
		model.addAttribute("productList", productList);
		
		return "/products/form-productin";
	}
	
	@PostMapping("/save")
	public String saveProductIn(@ModelAttribute("productIn") ProductIn productIn) {
		
		if(productIn.getId() == 0) {
			// save the productIn		
			this.productInService.save(productIn);
		} else if(productIn.getId() > 0) {
			// update the productIn
			this.productInUpdate.update(productIn);
		}
			
		return "redirect:/products-in/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productInId") int theId) {
		
		// delete the productIn
		this.productInService.deleteById(theId);
		
		return "redirect:/products-in/list";
		
	}
	
	@GetMapping("/export")
	public String exportTable(Model model) {
		
		List<ProductIn> productInList = this.productInService.findAll();
		
		int totalPriceProduct = this.productInService.totalPrice();
		
		// add to spring model
		model.addAttribute("productInList", productInList);
		
		model.addAttribute("totalPriceProduct", totalPriceProduct);
		
		return "/exportable/productin-export";
	}
	
	
	
	
	
	
	
	
}
