package com.The360company.portfolio.inventorymanagement.controller;

import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.The360company.portfolio.inventorymanagement.entity.Product;
import com.The360company.portfolio.inventorymanagement.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService<Product> productService;

	public ProductController(ProductService<Product> theProductService) {
		this.productService = theProductService;
	}
	
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listProduct(Model model) {
		
		// get product from db
		List<Product> products = this.productService.findAll();
		
		// get total price of product
		int totalPriceProduct = this.productService.totalPrice();
		
		// add total to the spring model
		model.addAttribute("totalPriceProduct",totalPriceProduct);
		
		// add to the spring model
		model.addAttribute("products", products);
		
		return "/products/list-products";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind form data
		Product product = new Product();
		
		model.addAttribute("product", product);
		
		return "/products/product-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int id,
								   Model model) {
		// get the product from the service
		Product theProduct = this.productService.findById(id);
		
		// set product as a model attribute to pre-populate the form
		model.addAttribute("product", theProduct);
		
		// send over to our form
		return "/products/product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		

		// save the product
		this.productService.save(theProduct);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/products/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int theId) {
		
		// delete the product
		this.productService.deleteById(theId);
		
		// redirect to /products/list
		return "redirect:/products/list";
	}
	
	@GetMapping("/export")
	public String exportTable(Model model) {
		
		// get product form db
		List<Product> products = this.productService.findAll();
		
		// get total price of product
		int totalPriceProduct = this.productService.totalPrice();
		
		// add total to spring model
		model.addAttribute("totalPriceProduct",totalPriceProduct);
		
		// add to the spring model
		model.addAttribute("products", products);
		
		return "/exportable/products";
	}
	
	/*
	
	// this controller is unnecessary because we have already have dataTable input filter
	
	@GetMapping("/search")
	public String delete(@RequestParam("productName") String name,
						Model model) {
		
		// delete the product
		List<Product> theProduct = this.productService.searchBy(name);
		
		// get total price of product
		int totalPriceProduct = this.productService.totalPrice();
		
		// add to the spring model
		model.addAttribute("products", theProduct);
		
		// add total to the spring model
		model.addAttribute("totalPriceProduct",totalPriceProduct);
		
		// send to /products/list
		return "/products/list-products";
	}
	
	*/
	
}
