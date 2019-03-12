package com.backendpro.dao;

import java.util.List;

import com.backendpro.model.Category;

public interface CategoryDao {
	
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	List<Category> getAllCategories();
	boolean deleteCategory(int categoryId);
	Category getCategoryById(int categoryId);

}
