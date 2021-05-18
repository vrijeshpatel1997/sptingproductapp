package com.product.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.dao.ProductRepository;
import com.product.demo.model.Product;

@Service
public class ProductService {
	
	
	@Autowired
ProductRepository productrepo;




public Product save (Product product) {
	
	return productrepo.save(product);
}


public Iterable<Product> getall(){
	return productrepo.findAll();
}


public Product findById(long productid) {
	return productrepo.findById(productid);
}

public List<Product> gettproduct(){
	return productrepo.findAll();
}

public void delete(Product product) {
productrepo.delete(product);
	
}
}