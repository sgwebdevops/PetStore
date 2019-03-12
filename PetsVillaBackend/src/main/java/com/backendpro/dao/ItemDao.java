package com.backendpro.dao;

import java.util.List;

import com.backendpro.model.Item;

public interface ItemDao {
	
	public boolean addItem(Item item);
	public boolean updateItem(Item item);
	public boolean deleteItem(int itemId);
	public Item getItemByProductnCustomerId(int productId, String customerId);
	public List<Item> getItemsListByCart(int cartId);
	public boolean increaseQuantity(int itemId);
	public boolean decreaseQuantity(int itemId);
	public Item getItemById(int itemId);

}
