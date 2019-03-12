package com.frontend.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backendpro.dao.CartDao;
import com.backendpro.dao.OrderDao;
import com.backendpro.dao.ProductDao;
import com.backendpro.dao.UserDao;
import com.backendpro.model.Address;
import com.backendpro.model.Cart;
import com.backendpro.model.Item;
import com.backendpro.model.Order;
import com.backendpro.model.Product;
import com.backendpro.model.User;

@Controller
public class PaymentController {
	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	HttpSession session;
	
	
	User userObj;
	
	Address addrObj;	
	private String userEmailId;
	
	@ModelAttribute
	public void getUserEmailId(HttpServletRequest request){
		Principal pObj = request.getUserPrincipal();
		userEmailId = pObj.getName();
		userObj=userDao.getUserById(userEmailId);
		
	}

	@RequestMapping(value="/thankYou",method=RequestMethod.GET)
	public ModelAndView thankYou(){
		System.out.println("Hello");
		Order orderObj = new Order();
		orderObj.setUserEmail(userEmailId);
		orderObj.setOrderDate(new Date());
		orderObj.setAddressId((int)session.getAttribute("addressId"));
		orderObj.setTotalAmount((double) session.getAttribute("grandTotal"));
		orderDao.makeOrder(orderObj);
		Cart cObj= cartDao.getCartByCustomer(userEmailId);
		Collection<Item> items = cObj.getItems();
		for(Item itemList:items){
			Product pObj = itemList.getProduct();
			pObj.setProductQuantity(pObj.getProductQuantity()-itemList.getQuantity());
			productDao.updateProduct(pObj);
			cartDao.deleteCart(cObj.getCartId());
		}
		/*Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();*/
		
		ModelAndView mv = new ModelAndView("ThankyouPage");
		String name = userObj.getFirstName();
		mv.addObject("name",name);
		mv.addObject("OrderDetails",orderObj.getOrderId());
		mv.addObject("totalAmount",orderObj.getTotalAmount());
		
		return mv;
	}
}
