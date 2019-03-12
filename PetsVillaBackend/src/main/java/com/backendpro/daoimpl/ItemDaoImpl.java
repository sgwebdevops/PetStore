package com.backendpro.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backendpro.dao.ItemDao;
import com.backendpro.model.Item;

@Repository("itemDao")
@Transactional
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addItem(Item item) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(item);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateItem(Item item) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.update(item);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteItem(int itemId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Item item = session.get(Item.class, itemId);
			session.delete(item);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public Item getItemByProductnCustomerId(int productId, String customerId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Item where productId=:x and customerId=:y");
			query.setParameter("x", productId);
			query.setParameter("y", customerId);
			List<Item> itemList = query.getResultList();
			if(itemList.size()!=0){
				return itemList.get(0);
			}
		}
		catch(Exception e){
			
		}
		return null;
	}

	public List<Item> getItemsListByCart(int cartId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Item where cart.cartId=:x");
			query.setParameter("x", cartId);
			List<Item> itemListByCart = query.getResultList();
			return itemListByCart;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean increaseQuantity(int itemId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Item itemObj = session.get(Item.class, itemId);
			itemObj.setQuantity(itemObj.getQuantity()+1);
			session.merge(itemObj);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean decreaseQuantity(int itemId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Item itemObj = session.get(Item.class, itemId);
			itemObj.setQuantity(itemObj.getQuantity()-1);
			if(itemObj.getQuantity()==0){
				return false;
			}
			session.merge(itemObj);
			return true;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Item getItemById(int itemId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Item itemObj = session.get(Item.class, itemId);
			return itemObj;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
