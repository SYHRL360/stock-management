package com.The360company.portfolio.inventorymanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="product_name")
	private String productName;
		
	@Column(name="price")
	private int price;
	
	@Column(name="quantity")
	private int quantity;
	
	// add new field for ProductIn and ProductOut
	// add @OneToOne annotation
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<ProductIn> productInList;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<ProductOut> productOutList;

	public Product() {
		
	}


	public Product(String productName, int price, int quantity) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Transient
	public int getQuantityProductIn() {
		
		int total = 0;
		for(ProductIn productIn : this.productInList) {
			total += productIn.getQuantity();
		}
		
		return total;
	}
	
	@Transient
	public int getQuantityProductOut() {
		
		int total = 0;
		for(ProductOut productOut : this.productOutList) {
			total += productOut.getQuantity();
		}
		
		return total;
	}

	@Transient
	public int getSubtotal() {
		return this.getPrice() * this.getQuantity();
	}
	
	
}
