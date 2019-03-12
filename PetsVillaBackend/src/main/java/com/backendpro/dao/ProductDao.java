package com.backendpro.dao;

import java.util.List;

import com.backendpro.model.Product;

public interface ProductDao {
	
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	List<Product> getAllProducts();
	boolean deleteProduct(int productId);
	Product getProductById(int productId);
	List<Product> getProductListByCategoryId(int categoryId);
	List<Product> getProductListBySupplierId(int supplierId);

}
