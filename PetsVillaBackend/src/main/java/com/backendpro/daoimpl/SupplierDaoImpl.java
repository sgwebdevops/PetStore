package com.backendpro.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backendpro.dao.SupplierDao;
import com.backendpro.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addSupplier(Supplier supplier) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(supplier);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSupplier(Supplier supplier) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.update(supplier);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public List<Supplier> getAllSuppliers() {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Supplier");
			return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteSupplier(int supplierId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Supplier supplier = session.get(Supplier.class, supplierId);
			session.delete(supplier);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public Supplier getSupplierById(int supplierId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Supplier sObj = session.get(Supplier.class, supplierId);
			return sObj;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
