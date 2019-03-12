package com.backendpro.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.backendpro.dao.UserDao;
import com.backendpro.model.Address;
import com.backendpro.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImp implements UserDao {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) {
		try{
			Session session = sessionFactory.getCurrentSession();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			session.save(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/*@Override
	public boolean validateUser(String emailId, String password) {
		// TODO Auto-generated method stub
		return false;
	}
*/
	public User getUserById(String emailId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			User userObj = session.get(User.class, emailId);
			return userObj;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAddress(Address addr) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(addr);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteAddress(Address addr) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.delete(addr);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAddress(Address addr) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.update(addr);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Address getAddressById(int addressId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Address addr = session.get(Address.class, addressId);
			return addr;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Address> getAllAddressforUser(String email) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Address where userObj.emailId=:x");
			query.setParameter("x",email);
			return query.getResultList();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		return null;
	}

	

}
