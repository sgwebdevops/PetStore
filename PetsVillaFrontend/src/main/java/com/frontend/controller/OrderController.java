package com.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	
	@Autowired
	HttpSession session;

	@RequestMapping(value="/payment",method=RequestMethod.GET)
	public ModelAndView payment(){
		double totalAmount = (double)session.getAttribute("grandTotal");
		ModelAndView mv = new ModelAndView("PaymentPage");
		mv.addObject("totalAmount", totalAmount);
		return mv;
	}
}
