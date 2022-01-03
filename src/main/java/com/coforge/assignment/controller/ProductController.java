package com.coforge.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.coforge.assignment.Repository.ProductRepository;
import com.coforge.assignment.model.Product;
import com.coforge.assignment.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/product")

public class ProductController {

	@Autowired
	private ProductService pService;
	
	@Autowired
	private ProductRepository pRepo;
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id){
		return new ResponseEntity<>(pService.findAllProductsByProductId(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product> > getProduct(Product product){
		return new ResponseEntity<>(pService.findAllProducts(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(pService.saveNewProduct(product),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long id, @Validated @RequestBody Product product)
	{
	Product p=pRepo.getById(id);
	
	p.setProductName(product.getProductName());
	p.setPrice(product.getPrice());
	p.setCustId(product.getCustId());

	final Product updatedProduct=pRepo.save(p);//invokes save method of JPA Repository
	
	return ResponseEntity.ok().body(updatedProduct);

	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		
		return new ResponseEntity<>(pService.getProductById(id),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id){
		return (pService.deleteProduct(id));
	}
	
	@RequestMapping("/customer/{custId}")
	public List<Product> getProducts(@PathVariable("custId") Long custId){
		
		return this.pService.getProductOfCustomer(custId);
		
	}
	
	
}
