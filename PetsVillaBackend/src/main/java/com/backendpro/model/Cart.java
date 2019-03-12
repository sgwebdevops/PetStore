package com.backendpro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	
	private String customerId;
	
	/*@OneToOne
	private User user;*/
	
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER,mappedBy="cart")
	Set<Item> items = new HashSet<Item>();


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Set<Item> getItems() {
		return items;
	}


	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	/*public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
}*/
	

		
}
