package com.coforge.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.assignment.Repository.ProductRepository;
import com.coforge.assignment.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	
	
	@Autowired
	private ProductRepository pRepo;
	
	
    
	
	
	@Override
	public List<Product> getProductOfCustomer(Long customerId) {
		// TODO Auto-generated method stub
		List<Product> list2 = pRepo.findAll().stream().collect(Collectors.toList());
		return list2.stream().filter(product ->product.getCustId().equals(customerId)).collect(Collectors.toList());
	}

	@Override
	public Product saveNewProduct(Product product) {
		
		return pRepo.save(product);
		
		
	
	}

	@Override
	public Product findAllProductsByProductId(Long id) {
		// TODO Auto-generated method stub
		return pRepo.getById(id);
	}

	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		pRepo.deleteById(id);
		return "Product deleted Successfully!";
	}

	
	

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return pRepo.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return pRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return pRepo.findById(id).get();
	}

}
