package com.backendpro.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backendpro.dao.OrderDao;
import com.backendpro.model.Order;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean makeOrder(Order order) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(order);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
