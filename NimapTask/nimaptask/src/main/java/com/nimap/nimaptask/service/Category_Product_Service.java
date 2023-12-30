package com.nimap.nimaptask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.nimaptask.dao.Category_Product_Dao;
import com.nimap.nimaptask.dto.Category;
import com.nimap.nimaptask.dto.Product;
import com.nimap.nimaptask.repository.Category_Repository;
import com.nimap.nimaptask.repository.Product_Repository;

@Service
public class Category_Product_Service {
	@Autowired
	private Category_Product_Dao dao;
	

	
	
	//methods for category
	
	public Category saveCategory(Category category) {
		return dao.saveCategory(category);
		
	}
	
	public Optional<Category> getCategoryById(int id) {
		return dao.getCategoryById(id);
		
	}
	
	public Category updateCategoryById(Category category,int id)
	{
		Optional<Category> optional=dao.getCategoryById(id);
		category.setCid(id);
		return dao.saveCategory(category);
	
	}
	
	public void deleteCategoryByid(int id) {
		dao.deleteCategoryByid(id);
		
	}
	
	public List<Category> getAllCategories(int pageNumber,int pageSize) {
		return dao.getAllCategories(pageNumber, pageSize);
	}
		
	//=============================================================
	
	//methods for product
	
	public Product saveProduct(Product product) {
		return dao.saveProduct(product);
		
	}
	
	public Optional<Product> getProductById(int id) {
		return dao.getProductById(id);
		
	}
	
	public Product updateProductById(Product product,int id)
	{
		Optional<Product> optional=dao.getProductById(id);
		product.setPid(id);
		return dao.saveProduct(product);

	}
	
	
	public void deleteProductByid(int id) {
		dao.deleteProductByid(id);
		
	}	
	
	public List<Product> getAllProducts(int pageNumber,int pageSize) {
		return dao.getAllProducts(pageNumber, pageSize);
	}
	
	
	
	

}
