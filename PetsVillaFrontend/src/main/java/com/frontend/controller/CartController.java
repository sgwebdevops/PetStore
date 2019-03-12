package com.frontend.controller;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backendpro.dao.CartDao;
import com.backendpro.dao.ItemDao;
import com.backendpro.dao.ProductDao;
import com.backendpro.dao.UserDao;
import com.backendpro.model.Cart;
import com.backendpro.model.Item;
import com.backendpro.model.Product;
import com.backendpro.model.User;

@Controller
public class CartController {
	
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
	
	private int totalItems=0;
	
	@ModelAttribute
	public void getUserEmailId(HttpServletRequest request){
		Principal pObj = request.getUserPrincipal();
		userEmailId = pObj.getName();
		userObj=userDao.getUserById(userEmailId);
	}
	
	@RequestMapping(value="/addtoCart/{productId}", method=RequestMethod.GET)
	public String addtoCart(@PathVariable("productId") int productId){
		Cart cart = cartDao.getCartByCustomer(userEmailId);
		if(cart==null){
			cart = new Cart();
			cart.setCustomerId(userEmailId);
			cartDao.addCart(cart);
		}
		
		Product pObj = productDao.getProductById(productId);
		Item itemObj = itemDao.getItemByProductnCustomerId(pObj.getProductId(), userEmailId);
		
		if(itemObj==null){
			itemObj = new Item();
			itemObj.setCart(cart);
			itemObj.setCustomerId(userEmailId);
			itemObj.setProduct(pObj);
			itemObj.setPrice(pObj.getProductPrice());
			itemObj.setQuantity(1);
			
			itemDao.addItem(itemObj);
		}
		else{
			itemDao.increaseQuantity(itemObj.getItemId());
		}
		
		return "redirect:/viewCart";
	}
	
	@RequestMapping(value="/viewCart", method=RequestMethod.GET)
	public ModelAndView viewCart(){
		Cart cart = cartDao.getCartByCustomer(userEmailId);
		ModelAndView mv = new ModelAndView();
		if(cart==null){
			totalItems=0;
			mv=new ModelAndView("Cart");
			mv.addObject("msg","You cart is empty");
			return mv;
		}
		else{
			int cartId=cart.getCartId();
			List<Item> cartItemList  = itemDao.getItemsListByCart(cartId);
			
			double cartItemPrice = 0;
			for(Item item:cartItemList){
				cartItemPrice += (item.getPrice()*item.getQuantity());
				//totalItems += item.getQuantity();
			}
			totalItems =cartItemList.size();
			mv=new ModelAndView("Cart");
			mv.addObject("cartItems",cartItemList);
			mv.addObject("total",cartItemPrice);
			mv.addObject("totalItems", totalItems);
			session.setAttribute("cartItemList", itemDao.getItemsListByCart(cartId));
			session.setAttribute("grandTotal",cartItemPrice);
			session.setAttribute("totalItems",totalItems);
			return mv;
		}
		
	}
	
	@RequestMapping(value="increaseQuantity/{itemId}/{productId}",method=RequestMethod.GET)
	public String increase(@PathVariable("itemId") int itemId, @PathVariable("productId") int productId, Model map){
		Item itemObj = itemDao.getItemById(itemId);
		Product pObj = productDao.getProductById(productId);
		int stock = pObj.getProductQuantity();
		if(stock>itemObj.getQuantity()){
		itemDao.increaseQuantity(itemId);}
		else{
			System.out.println("Out of stock");
			map.addAttribute("status","Out Of Stock");
		}
			return "redirect:/viewCart";
	}
	
	@RequestMapping(value="decreaseQuantity/{itemId}",method=RequestMethod.GET)
	public String decrease(@PathVariable("itemId") int itemId){
		Item itemObj = itemDao.getItemById(itemId);
		if(itemObj.getQuantity()>1){
		itemDao.decreaseQuantity(itemId);}
		else{
			System.out.println("lowest quantity");
		}
		return "redirect:/viewCart";
	}
	
	@RequestMapping(value="/deleteItem/{itemId}",method=RequestMethod.GET)
	public String deleteItem(@PathVariable("itemId")int itemId){
		//Item itemObj = itemDao.getItemById(itemId);
		itemDao.deleteItem(itemId);
		return "redirect:/viewCart";
	}
	
	
}


