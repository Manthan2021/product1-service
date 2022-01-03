package com.coforge.assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private Double price;
	private Long custId;


	

	public Product(Long productId, String productName, Double price, Long custId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.custId = custId;
	}


	public Product(String productName, Double price, Long custId) {
		super();
		this.productName = productName;
		this.price = price;
		this.custId = custId;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Long getCustId() {
		return custId;
	}


	public void setCustId(Long custId) {
		this.custId = custId;
	}




	

}
