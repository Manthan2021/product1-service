package com.coforge.assignment.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;


import com.coforge.assignment.model.Product;

public interface ProductService {

	public List<Product> getProductOfCustomer(Long customerId);
	
	Product saveNewProduct(Product product);

	Product findAllProductsByProductId(Long id);
	
	String deleteProduct(Long id);
	
	 public Product  getProductById(@PathVariable Long id);

	List<Product> findAllProducts();

	Product updateProduct( Product Product);
	
	
	
}
