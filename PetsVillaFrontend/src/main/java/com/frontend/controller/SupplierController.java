package com.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backendpro.dao.SupplierDao;
import com.backendpro.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	HttpSession session;

	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value="/addSupplier",method=RequestMethod.GET)
	public ModelAndView getSupplierForm(){
		ModelAndView mv = new ModelAndView("SupplierForm");
		mv.addObject("supplierObj",new Supplier());
		return mv;
		
	}
	
	@RequestMapping(value="/addSupplierProcess",method=RequestMethod.POST)
	public ModelAndView addSupplierProcess(@Valid @ModelAttribute("supplierObj")Supplier supplierObj, BindingResult result){
		if(result.hasErrors()){
			ModelAndView mv= new ModelAndView("SupplierForm");
			return mv;
		}
		else{
			ModelAndView mv=new ModelAndView("ViewAllSuppliers");
			
			if(supplierDao.addSupplier(supplierObj)){
				mv.addObject("msg","Supplier Added Succesfully");
			}
			else{
				mv.addObject("msg","Some problem occured");
			}
			mv.addObject("supplierList", supplierDao.getAllSuppliers());
			session.setAttribute("supplierList", supplierDao.getAllSuppliers());
			return mv;
		}
		
	}
	
	@RequestMapping(value="viewAllSuppliers",method=RequestMethod.GET)
	public ModelAndView getAllSuppliers(){
		List<Supplier> suppliers=supplierDao.getAllSuppliers();
		ModelAndView mv=new ModelAndView("ViewAllSuppliers");
		mv.addObject("supplierList",suppliers);
		return mv;
	}
	
	@RequestMapping(value="updateSupplier/{supId}",method=RequestMethod.GET)
	public ModelAndView updateSupplier(@PathVariable int supId){
		Supplier sObj = supplierDao.getSupplierById(supId);
		ModelAndView mv = new ModelAndView("UpdateSupplierForm");
		mv.addObject("supplierObj",sObj);
		return mv;
	}
	
	@RequestMapping(value="updateSupplierProcess",method=RequestMethod.POST)
	public ModelAndView updateSupplierProcess(@ModelAttribute("supplierObj") Supplier supplierObj){
		supplierDao.updateSupplier(supplierObj);
		ModelAndView mv = new ModelAndView("ViewAllSuppliers");
		mv.addObject("msg","Supplier Updated Successfully");
		mv.addObject("supplierList",supplierDao.getAllSuppliers());
		return mv;
	}
	
	@RequestMapping(value="deleteSupplier/{supId}",method=RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable int supId){
		supplierDao.deleteSupplier(supId);
		ModelAndView mv=new ModelAndView("ViewAllSuppliers");
		mv.addObject("msg","Supplier deleted Succesfully..");
		mv.addObject("supplierList",supplierDao.getAllSuppliers());
		return mv;
	}
}
	
