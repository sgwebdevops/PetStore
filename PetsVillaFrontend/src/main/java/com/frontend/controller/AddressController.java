package com.frontend.controller;

import java.security.Principal;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.backendpro.dao.CartDao;
import com.backendpro.dao.ItemDao;
import com.backendpro.dao.ProductDao;
import com.backendpro.dao.UserDao;
import com.backendpro.model.Address;
import com.backendpro.model.User;

@Controller
public class AddressController {
	@Autowired
	CartDao cartDao;
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ItemDao itemDao;
	
	User userObj;
	
	private String userEmailId;
	
	@ModelAttribute
	public void getUserEmailId(HttpServletRequest request){
		Principal pObj = request.getUserPrincipal();
		userEmailId = pObj.getName();
		userObj=userDao.getUserById(userEmailId);
	}
	
	
	@RequestMapping(value="getAddressPage",method=RequestMethod.GET)
	public ModelAndView getAddressPage(){
		Set<Address> addrs=userObj.getAddresses();
		
		ModelAndView mv=new ModelAndView("AddressPage");
		if(addrs.size()!=0){
		mv.addObject("addressList",addrs);
		}
		
		mv.addObject("addressObj",new Address());
		return mv;
	}
	
	@RequestMapping(value="addAddress",method=RequestMethod.POST)
	public String addAddress(@ModelAttribute("addressObj")Address addressObj){

	addressObj.setUserObj(userObj);
	userDao.addAddress(addressObj);
	return "redirect:getAddressPage";	
	}
	
	@RequestMapping(value="/updateAddress",method=RequestMethod.GET)
	public ModelAndView updateAddress(@RequestParam("address")int addressId){
		Address addrObj = userDao.getAddressById(addressId);
		ModelAndView mv = new ModelAndView("UpdateAddressPage");
		mv.addObject("addressObj",addrObj);
		return mv;
	}
	
	@RequestMapping(value="/updateAddressProcess",method=RequestMethod.POST)
	public ModelAndView updateAddressProcess(@ModelAttribute("addressObj")Address addrObj){
		addrObj.setUserObj(userObj);
		userDao.updateAddress(addrObj);
		Set<Address> addrs=userObj.getAddresses();
		ModelAndView mv=new ModelAndView("redirect:/getAddressPage");
		//mv.addObject("addressObj",addressObj);
		return mv;
		
	}
	
	@RequestMapping(value = "/deleteAddress",method=RequestMethod.GET)
	public String deleteAddress(@RequestParam("address")int addressId){
		Address addrObj = userDao.getAddressById(addressId);
		userDao.deleteAddress(addrObj);
		return "redirect:getAddressPage";
		
	}
	
	@RequestMapping(value="/confirmationPage",method=RequestMethod.GET)
	public ModelAndView confirmationPage(@RequestParam("address")int addressId){
		Address addrObj = userDao.getAddressById(addressId);
		ModelAndView mv = new ModelAndView("ConfirmationPage");
		mv.addObject("addressObj",addrObj);
		session.setAttribute("addressObj",addrObj);
		session.setAttribute("addressId", addressId);
		return mv;
	}
	
	

}
