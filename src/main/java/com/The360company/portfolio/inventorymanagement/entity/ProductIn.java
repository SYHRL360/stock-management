package com.The360company.portfolio.inventorymanagement.entity;



import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product_in")
public class ProductIn {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="id_product")
	private Product product;
	
	@Column(name="tanggal")
	private Date currentDate;
	
	@Column(name="quantity")
	private int quantity;
	
	public ProductIn() {
		
	}

	public ProductIn(Product product, Date currentDate, int quantity) {
		this.product = product;
		this.currentDate = currentDate;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
			this.currentDate = currentDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Transient
	public int getSubtotal() {
		return this.product.getPrice() * this.getQuantity();
	}

	@Override
	public String toString() {
		return "ProductIn [id=" + id + ", product=" + product + ", currentDate=" + currentDate + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
}
