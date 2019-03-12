package com.backendpro.dao;

import com.backendpro.model.Cart;

public interface CartDao {

	public boolean addCart(Cart cart);
	public Cart getCartByCustomer(String customerId);
	public boolean deleteCart(int cartId);
}
