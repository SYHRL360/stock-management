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
import com.The360company.portfolio.inventorymanagement.entity.ProductOut;
import com.The360company.portfolio.inventorymanagement.service.ProductService;
import com.The360company.portfolio.inventorymanagement.service.ProductUpdate;

@Controller
@RequestMapping("/products-out")
public class ProductOutController {

	private ProductService<Product> productService;
	
	private ProductService<ProductOut> productOutService;
	
	private ProductUpdate<ProductOut> productOutUpdate;
 	
	public ProductOutController(ProductService<Product> productService,
								ProductService<ProductOut> productOutService,
								ProductUpdate<ProductOut> productOutUpdate) {
		this.productService = productService;
		this.productOutService = productOutService;
		this.productOutUpdate = productOutUpdate;
		
	}
	
	@GetMapping("/list")
	public String productOutList(Model model) {
		
		List<ProductOut> productOutList = this.productOutService.findAll();
		
		int totalPriceProduct = this.productOutService.totalPrice();
		
		// add to spring model
		model.addAttribute("productOutList", productOutList);
	
		model.addAttribute("totalPriceProduct", totalPriceProduct);
		
		return "products/product-out";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("productOutId") int id,
								Model model) {
		List<Product> productList = this.productService.findAll();
		
		// get the productOut the service
		ProductOut productOutUpdate = this.productOutService.findById(id);
		
		List<Product> searchProduct = productList
									  .stream()
									  .filter(p -> p.getProductName().equals(productOutUpdate.getProduct().getProductName()))
									  .collect(Collectors.toList());
		
		// send productOut as a model attribute to pre-populate the page
		model.addAttribute("productOut", productOutUpdate);
		
		model.addAttribute("productList", searchProduct);
		
		// send over to our page
		return "/products/form-productout";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		List<Product> productList = this.productService.findAll();
		
		// create model attribute to bind form data
		ProductOut productOut = new ProductOut();
		
		model.addAttribute("productOut", productOut);
		
		model.addAttribute("productList", productList);
		
		return "/products/form-productout";
	}
	
	@PostMapping("/save")
	public String saveProductOut(
				@ModelAttribute("productOut") ProductOut productOut,
				Model model) {
		
		Product currentProduct = this.productService.findById(productOut.getProduct().getId());
		
		List<Product> productList = this.productService.findAll();
		// check whether we add new productOut or we want to update productOut
		if(productOut.getId() == 0) {
			
			// check if productOut quantity has exceeded
			if (productOut.getQuantity() > currentProduct.getQuantity() || currentProduct.getQuantity() <= 0) {
				
				model.addAttribute("productOut", new ProductOut());
				model.addAttribute("productList", productList);
				model.addAttribute("productExceeded", "Jumlah stok barang tidak cukup!");

				return "/products/form-productout";
			}
			
			this.productOutService.save(productOut);
			
		} else if(productOut.getId() > 0) {
			
			if (productOut.getQuantity() > currentProduct.getQuantity() || currentProduct.getQuantity() <= 0) {
				
				List<Product> searchProduct = productList
											  .stream()
											  .filter(p -> p.getProductName().equals(productOut.getProduct().getProductName()))
											  .collect(Collectors.toList());
				// send productOut as a model attribute to pre-populate the page
				model.addAttribute("productOut", productOut);
				model.addAttribute("productList", searchProduct);
				model.addAttribute("productExceeded", "Jumlah stok barang tidak cukup!");
				
				return "/products/form-productout";
			}
			
			this.productOutUpdate.update(productOut);
		}
		
		return "redirect:/products-out/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productOutId") int id) {
		
		// delete the productOut
		this.productOutService.deleteById(id);
		
		return "redirect:/products-out/list";
	}
	
	@GetMapping("/export")
	public String exportTable(Model model) {
	
		List<ProductOut> productOutList = this.productOutService.findAll();
		
		int totalPriceProduct = this.productOutService.totalPrice();
		
		// add to spring model
		model.addAttribute("productOutList", productOutList);
		
		model.addAttribute("totalPriceProduct",totalPriceProduct);
		
		return "/exportable/productout-export";
	}

}
