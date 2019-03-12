package com.backendpro.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.backendpro.model.Address;
import com.backendpro.model.Cart;
import com.backendpro.model.Category;
import com.backendpro.model.Item;
import com.backendpro.model.Order;
import com.backendpro.model.Product;
import com.backendpro.model.Supplier;
import com.backendpro.model.User;



@Configuration
@EnableTransactionManagement
@ComponentScan("com.backendpro")
public class DBConfig 
{
	
	
	//1. Create a DataSource object in config
	@Bean(name="dataSource") 
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("swati");
		dataSource.setPassword("sgdevops");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/sgdevopsdb");
		System.out.println("===Creating the DataSource Bean=====");
		return dataSource;
	}
	
	//2. Create a SessionFactory object
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.show_sql",true);
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
		factory1.addProperties(hibernateProperties);
		factory1.addAnnotatedClass(Category.class);
		factory1.addAnnotatedClass(Product.class);
		factory1.addAnnotatedClass(Supplier.class);
		factory1.addAnnotatedClass(User.class);
		factory1.addAnnotatedClass(Cart.class);
		factory1.addAnnotatedClass(Item.class);
		factory1.addAnnotatedClass(Address.class);
		factory1.addAnnotatedClass(Order.class);
		SessionFactory sessionFactory=factory1.buildSessionFactory();
		
		System.out.println("===Creating the SessionFactory Bean=====");
		return sessionFactory;
	}
	
	//3. Create a HibernateTransactionManager
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("===Creating the TransactionManager Bean=====");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordEncoder(){
		System.out.println("Creating password Encoder"); 
		return new BCryptPasswordEncoder();
	}
	

}