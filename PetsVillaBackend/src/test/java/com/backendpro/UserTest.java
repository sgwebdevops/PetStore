package com.backendpro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backendpro.config.DBConfig;
import com.backendpro.dao.UserDao;
import com.backendpro.model.Address;
import com.backendpro.model.User;


/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/

/**
 * Unit test for simple App.
 */
public class UserTest{
   static UserDao userDao;
	
	
	@BeforeClass
	public static void init(){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.register(DBConfig.class);
	context.refresh();
	
	userDao=context.getBean("userDao",UserDao.class);
	
	}
	
	
    @Test
    @Ignore
    public void addUserTest()
    {
        /*Address add = new Address();
        add.setHouseNumber("A-11");
        add.setLocality("Rohini");
        add.setCity("New Delhi");
        add.setPincode(110085);*/
        
    	User user=new User();
        user.setEmailId("user@gmail.com");
        user.setPassword("abcd@123");
        user.setFirstName("abhay");
        user.setLastName("Goel");
        /*user.setAddress(add);*/
        user.setConfirmPassword("abcd@123");
        user.setMobileNumber("1234567890");
        user.setRole("user");
        user.setEnabled(true);
        System.out.println("UserDao: "+userDao);
        boolean r=userDao.addUser(user);
        assertTrue("Problem in Adding User",r);
        
    }
    
  @Test
  @Ignore
  public void updateAddress(){
	  Address addr = userDao.getAddressById(241);
	  addr.setAddressLine1("K6");
	  boolean r =  userDao.updateAddress(addr);
	  assertTrue("Problem Updating Address",r);
  }
}
