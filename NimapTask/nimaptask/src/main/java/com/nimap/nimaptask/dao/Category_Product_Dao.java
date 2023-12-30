package com.nimap.nimaptask.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.nimap.nimaptask.dto.Category;
import com.nimap.nimaptask.dto.Product;
import com.nimap.nimaptask.repository.Category_Repository;
import com.nimap.nimaptask.repository.Product_Repository;

@Repository
public class Category_Product_Dao {
	
	@Autowired
	private Category_Repository category_Repository;
	
	@Autowired
	private Product_Repository product_Repository;
	
	//methods for category
	public Category saveCategory(Category category) {
		List<Product>products=category.getProducts();
		for (Product product : products) {
			product.setCategory(category);
		}
		return category_Repository.save(category);
		
	}
	
	public Optional<Category> getCategoryById(int id) {
		return category_Repository.findById(id);
		
	}
	
	public Category updateCategoryById(Category category,int id)
	{
		Optional<Category> optional=category_Repository.findById(id);
		category.setCid(id);
		return category_Repository.save(category);
	
	}
	
	
		
	public void deleteCategoryByid(int id) {
		category_Repository.deleteById(id);
		
	}
	
	public List<Category> getAllCategories(int pageNumber,int pageSize) {
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Category>page=category_Repository.findAll(p);
		return page.getContent();
		
		
	}
	
	//=================================================
	
	//methods for product
	
	public Product saveProduct(Product product) {
		return product_Repository.save(product);
		
	}
	
	public Optional<Product> getProductById(int id) {
		return product_Repository.findById(id);
		
	}
	
	public Product updateProductById(Product product,int id)
	{
		Optional<Product> optional=product_Repository.findById(id);
		product.setPid(id);
		return product_Repository.save(product);
	
	}
	
	public void deleteProductByid(int id) {
		Optional<Product>optProduct=product_Repository.findById(id);
		if(optProduct.isPresent())
		{
		  Product deleteProduct= optProduct.get();
		  Category productcategory =deleteProduct.getCategory();
		  
		  if(productcategory!=null)
		  {
			  productcategory.getProducts().remove(deleteProduct);
		  }
		  else {
			  System.out.println("product has no such category");
			  
		  }
		  product_Repository.delete(deleteProduct);
		}
		
	}
	
	public List<Product> getAllProducts(int pageNumber,int pageSize) {
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Product>page=product_Repository.findAll(p);
		return page.getContent();
		
		
	}
	
	
	

}
