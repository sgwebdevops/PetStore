package com.backendpro.dao;

import java.util.List;

import com.backendpro.model.Address;
import com.backendpro.model.User;

public interface UserDao {
	public boolean addUser(User user);
    public User getUserById(String emailId);
    public boolean addAddress(Address addr);
    public boolean deleteAddress(Address addr);
    public boolean updateAddress(Address addr);
    public Address getAddressById(int addressId);
    public List<Address> getAllAddressforUser(String email);
    
	
}
