package com.backendpro.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backendpro.dao.ProductDao;
import com.backendpro.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) {
		try{
		Session session=sessionFactory.getCurrentSession();
		session.save(product);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(Product product) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(product);
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	public List<Product> getAllProducts() {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Product");
			return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteProduct(int productId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Product pObj = session.get(Product.class, productId);
			session.delete(pObj);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public Product getProductById(int productId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Product pObj = session.get(Product.class, productId);
			return pObj;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getProductListByCategoryId(int categoryId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Product where categoryId=:x");
			query.setParameter("x", categoryId);
			return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getProductListBySupplierId(int supplierId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Product where supplierId=:x");
			query.setParameter("x", supplierId);
			return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
