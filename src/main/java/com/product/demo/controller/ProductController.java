package com.product.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.demo.dao.ProductRepository;
import com.product.demo.model.Product;
import com.product.demo.services.ProductService;




@Controller


public class ProductController

{
	
	@Autowired
	ProductRepository productrepo;
	
	@Autowired
	ProductService productservice;
	
	@RequestMapping("/new")
	public String newproduct(Model model) {
		
		Product product = new Product();
		
		model.addAttribute("aProduct", product);
		 return "newproduct";
		
		
		
	}
	
	@GetMapping("/")
	public String homepage(Model model) {
		return "home";
		
	}

	@PostMapping("/save")
	
	public String saveproduct(Model model, Product product) {
	productrepo.save(product);
		
		return "productlist";
		
	}
	
	
	@RequestMapping("/display")
	public String displayproduct(Model model) {
	List<Product> products = productrepo.findAll();
		model.addAttribute("aProduct", products);
		
	
		
		
		return "home";
		
		
	}
	
	@GetMapping("/update")
	public String displayproductform(@RequestParam("id")long productid, Model model) {
		
		Product product = productservice.findById(productid);
		model.addAttribute("aProduct", product);
		 return "newproduct";
		 
		 
	}
  
	@GetMapping("/delete")
	public String deleteproduct(@RequestParam("id")long productid, Model model){
		Product product = productservice.findById(productid);
		productservice.delete(product);
		return "productlist";
		
		
	}
	
	
}