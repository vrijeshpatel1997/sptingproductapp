package com.product.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.product.demo.model.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {
	
	
	@Override
	public List<Product> findAll();

	public Product findById(long productid);

	
	
}