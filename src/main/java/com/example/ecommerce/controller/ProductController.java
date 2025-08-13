package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// Test Flow
	// 1) Create a Product - POST localhost:8080/api/products?categoryId=1&tagIds=1,2
	// 2) Get all products or get product by id = localhost:8080/api/products
	// 3) Get all categories, or get category by id = localhost:8080/api/categories
	/// localhost:8080/api/products?categoryId=1
	@PostMapping
	public Product addProduct (@RequestBody Product product,@RequestParam Long categoryId,
			@RequestParam List<Long> tagIds) {
		// Now to create a new product i have to specify the category ID - DTO
		// Temporarily use RequestParam
		// Best practice use proper DTO
		return productService.createProduct(product, categoryId,tagIds);
	}
	
	@GetMapping
	public List<Product>getAllProducts(){
		return productService.getAllProducts();
	}
}
