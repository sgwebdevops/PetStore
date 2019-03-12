package com.frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.backendpro.dao.UserDao;
import com.backendpro.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	
	@RequestMapping(value="/registerUser",method=RequestMethod.GET)
	public ModelAndView getRegisterForm(){
	ModelAndView mv=new ModelAndView("SignUpForm");
	mv.addObject("userObj",new User());
	return mv;
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView doRegister(@Valid @ModelAttribute("userObj") User userObj, BindingResult result){
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("SignUpForm");
			return mv;
		}
		else{
			if(!(userObj.getPassword()).equals(userObj.getConfirmPassword())){
				ModelAndView mv = new ModelAndView("SignUpForm");
				mv.addObject("msg","Password and Confirm password don't match");
				return mv;
			}
			else{
			userObj.setEnabled(true);	
			userObj.setRole("User");	
			userDao.addUser(userObj);	
			ModelAndView mv=new ModelAndView("Login");
			return mv;}
		}
		
		
	}


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginUser(@RequestParam(name="logout",required=false)String logout,
   		 @RequestParam(name="error",required=false)String error) {
   	 ModelAndView mv = new ModelAndView("Login");
   	 if(logout!=null){
   		 mv.addObject("msg","Logged Out Successfully");
   	 }
   	 if(error!=null){
   		 mv.addObject("msg","Email or Password is incorrect");
   	 }
/*	    	 List<Category> categories=categoryDao.getAllCategories();
		 mv.addObject("categoryList",categories);
*/
   	 return mv; 
    }
    
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDeniedPage() {
   	 ModelAndView mv = new ModelAndView("AccessDenied");
   	 return mv; 
    }
    
    @RequestMapping(value = "/errorPage", method = RequestMethod.GET)
    public String errorPage() {
   	 return "redirect:/login?error"; 
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,HttpServletResponse response) {
   	 Authentication auth=SecurityContextHolder.getContext().getAuthentication();
   	 if(auth!=null) {
   		 new SecurityContextLogoutHandler().logout(request, response, auth);
   	 }
   	 
   	 return "redirect:/login?logout"; 
    }
}
