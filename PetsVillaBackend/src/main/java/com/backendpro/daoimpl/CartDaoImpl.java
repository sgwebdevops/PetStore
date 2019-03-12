package com.backendpro.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backendpro.dao.CartDao;
import com.backendpro.model.Cart;


@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCart(Cart cart) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(cart);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	public Cart getCartByCustomer(String customerId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Cart where customerId=:x");
			query.setParameter("x", customerId);
			List<Cart> cartList = query.getResultList();
			if(cartList.size()!=0){
				return cartList.get(0);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteCart(int cartId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Cart cart = session.get(Cart.class, cartId);
			session.delete(cart);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
