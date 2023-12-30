package com.nimap.nimaptask.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.nimaptask.dto.Category;
import com.nimap.nimaptask.dto.Product;
import com.nimap.nimaptask.service.Category_Product_Service;

@RestController
public class Category_Product_Controller {
	
	@Autowired
	private Category_Product_Service service;
	

	//methods for category
	
	@PostMapping("/api/categories")
	public Category saveCategory(@RequestBody Category category) {
		return service.saveCategory(category);
		
	}
	
	@GetMapping("/api/categories/{di}")
	public Optional<Category> getCategoryById(@PathVariable("di") int id) {
		return service.getCategoryById(id);
		
	}
	
	@PutMapping("/api/categories/{di}")
	public Category updateCategoryById(@RequestBody Category category,@PathVariable("di")int id)
	{
		return service.updateCategoryById(category, id);
	
	}
	
	@DeleteMapping("/api/categories/{di}")
	public void deleteCategoryByid(@PathVariable("di") int id) {
		service.deleteCategoryByid(id);
		
	}
	
	@GetMapping("/api/categories")
	public List<Category> getAllCategories(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber ,
			@RequestParam (value = "pageSize",defaultValue = "50",required = false) int pageSize)
	{
		return service.getAllCategories(pageNumber, pageSize);
	}
	
	//======================================================
	

	//methods for products
	
	@PostMapping("/api/products")
	public Product saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
		
	}
	
	
	@GetMapping("/api/products/{di}")
	public Optional<Product> getProductById(@PathVariable("di") int id) {
		return service.getProductById(id);
	}
	
	@PutMapping("/api/products/{di}")
	public Product updateProductById(@RequestBody Product product,@PathVariable("di")int id)
	{
		return service.updateProductById(product, id);
	
	}
	
	@DeleteMapping("/api/products/{di}")
	public void deleteProductByid(@PathVariable("di") int id) {
		service.deleteProductByid(id);
		
	}	
	
	@GetMapping("/api/products")
	public List<Product> getAllProducts(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber ,
			@RequestParam (value = "pageSize",defaultValue = "50",required = false) int pageSize)
	{
		return service.getAllProducts(pageNumber, pageSize);
	}
	

}
