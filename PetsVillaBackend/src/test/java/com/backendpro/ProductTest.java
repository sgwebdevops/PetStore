package com.backendpro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backendpro.config.DBConfig;
import com.backendpro.dao.ProductDao;
import com.backendpro.dao.SupplierDao;
import com.backendpro.model.Product;
import com.backendpro.model.Supplier;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/

/**
 * Unit test for simple App.
 */
public class ProductTest{
   static ProductDao productDao;
	
	
	@BeforeClass
	public static void init(){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.register(DBConfig.class);
	context.refresh();
	
	productDao=context.getBean("productDao",ProductDao.class);
	
	}
	
	
    @Test
    @Ignore
    public void addProductTest()
    {
        Product pObj=new Product();
        pObj.setProductName("Poodle");
        pObj.setProductDescription("beautiful dog");
        pObj.setCategoryId(4);
        pObj.setProductPrice(22000);
        pObj.setProductQuantity(4);
        pObj.setSupplierId(8);
        
    
        System.out.println("ProductDao : "+productDao);
        boolean r=productDao.addProduct(pObj);
        assertTrue("Problem in Adding Category",r);
        
    }
    
    @Test
    @Ignore
    public void getProductsByCategoryIdTest(){
    	List<Product> products = productDao.getProductListByCategoryId(5);
    	for(Product pObj:products){
    		System.out.println(pObj);
    	}
    	assertTrue("No Such Product Found", products.size()>0);
    }
    
    @Test
    @Ignore
    public void getProductsBySupplierIdTest(){
    	   	List<Product> products = productDao.getProductListBySupplierId(8);
        	for(Product pObj:products){
        		System.out.println(pObj);
        	}
        	assertTrue("No Such Product Found", products.size()>0);
    }
   }
    
