package com.coforge.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.assignment.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
