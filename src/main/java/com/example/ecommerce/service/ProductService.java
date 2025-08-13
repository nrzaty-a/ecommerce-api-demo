package com.example.ecommerce.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;

	// Create
	// Add a parameter categoryId so that i can retrieve the category
   public Product createProduct(Product product, Long categoryId, List<Long> tagIds) {
	   
	   // when i create a new product, i will get the category from categoryId
	   // and set it to the product
	   // transform it toset to ensure no repeated tag.
	    product.setCategory(categoryService.get(categoryId));
	    product.setTags(Set.copyOf(tagService.getByIds(tagIds)));

        return productRepository.save(product);
    }

	// Read
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	// Read byId
	public Product getProductById(Long id) {
		return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
	}
	// Update
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(existing);
    }	
	// Delete
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

	
}
