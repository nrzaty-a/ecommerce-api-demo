package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	// Get ALL
	@GetMapping
	List<Category> getAll(){
		return categoryService.getAll();
	}
	// Create method
	@PostMapping
	public Category create(@RequestBody Category category) {
		return categoryService.create(category);
	}
	
	// Get by Id
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable Long id) {
		return categoryService.get(id);
	}
}
