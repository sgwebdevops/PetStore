package com.backendpro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backendpro.config.DBConfig;
import com.backendpro.dao.CategoryDao;
import com.backendpro.dao.ProductDao;
import com.backendpro.dao.SupplierDao;
import com.backendpro.model.Category;
import com.backendpro.model.Product;
import com.backendpro.model.Supplier;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/

/**
 * Unit test for simple App.
 */
public class CategoryTest{
   static CategoryDao categoryDao;
	
	
	@BeforeClass
	public static void init(){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.register(DBConfig.class);
	context.refresh();
	
	categoryDao=context.getBean("categoryDao",CategoryDao.class);
	
	}
	
	
    @Test
    @Ignore
    public void addCategoryTest()
    {
        Category cObj=new Category();
        cObj.setCategoryName("Birds");
        cObj.setCategoryDescription("All kinds of birds");
        
    
        System.out.println("categoryDao : "+categoryDao);
        boolean r=categoryDao.addCategory(cObj);
        assertTrue("Problem in Adding Category",r);
        
    }
    
    @Test
    @Ignore
    public void getAllCategoriesTest(){
    	List<Category> categories = categoryDao.getAllCategories();
    	for(Category catList:categories){
    		System.out.println(catList);
    	}
    	assertTrue("No Category found",categories.size()>0);
    }
    
    @Test
    @Ignore 
    public void deleteCategory(){
    	boolean r = categoryDao.deleteCategory(13);
    	assertTrue("No category found", r);
    }
}

