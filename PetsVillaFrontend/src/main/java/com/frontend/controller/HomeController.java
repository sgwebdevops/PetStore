package com.frontend.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backendpro.dao.CategoryDao;
import com.backendpro.dao.ItemDao;
import com.backendpro.dao.SupplierDao;
import com.backendpro.dao.UserDao;
import com.backendpro.model.User;

@Controller
public class HomeController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ItemDao itemDao;

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView LoadHomePage(){
		Principal p=request.getUserPrincipal();
		if(p==null){
			System.out.println("principal is null");
		
		}
		else {
			String email=p.getName();
			User user=userDao.getUserById(email);
			
			session.setAttribute("userObj",user);
			
		}
		
		
		ModelAndView mv = new ModelAndView("Home");
		session.setAttribute("categoryList", categoryDao.getAllCategories());
		session.setAttribute("supplierList", supplierDao.getAllSuppliers());
		return mv;
		
	}
	
	
}
