package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Product;
import com.bhavna.service.ProductServiceI;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	ProductServiceI serv;
	
	@GetMapping("/list")
	public List<Product> getAllItems(){
		return serv.getAll();
	}
}
