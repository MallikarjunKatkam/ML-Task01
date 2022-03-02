package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.model.Product;
import com.bhavna.repository.ProductsRepo;

@Service
public class ProductServiceImpl implements ProductServiceI {
	@Autowired
	ProductsRepo repo;
	
	public List<Product> getAll(){
		return repo.findAll();
	}
}
