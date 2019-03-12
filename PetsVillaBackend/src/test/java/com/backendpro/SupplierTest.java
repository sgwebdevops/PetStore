package com.backendpro;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backendpro.config.DBConfig;
import com.backendpro.dao.SupplierDao;
import com.backendpro.model.Supplier;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/

/**
 * Unit test for simple App.
 */
public class SupplierTest{
   static SupplierDao supplierDao;
	
	
	@BeforeClass
	public static void init(){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.register(DBConfig.class);
	context.refresh();
	
	supplierDao=context.getBean("supplierDao",SupplierDao.class);
	
	}
	
	
    @Test
    @Ignore
    public void addSupplierTest()
    {
        Supplier sObj=new Supplier();
        sObj.setSupplierName("ram Lal");
        sObj.setSupplierAddress("South Ex");
    
        System.out.println("SupplierDao : "+supplierDao);
        boolean r=supplierDao.addSupplier(sObj);
        assertTrue("Problem in Adding Category",r);
        
    }
}
