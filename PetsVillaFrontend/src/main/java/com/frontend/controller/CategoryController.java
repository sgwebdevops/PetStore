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

import com.backendpro.dao.CategoryDao;
import com.backendpro.model.Category;

@Controller
public class CategoryController {
	@Autowired
	HttpSession session;
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/addCategory",method=RequestMethod.GET)
	public ModelAndView getCategoryForm(){
		ModelAndView mv = new ModelAndView("CategoryForm");
		mv.addObject("categoryObj",new Category());
		return mv;
		
	}
	
	@RequestMapping(value="/addCategoryProcess",method=RequestMethod.POST)
	public ModelAndView addCategoryProcess(@Valid @ModelAttribute("categoryObj")Category categoryObj, BindingResult result){
		if(result.hasErrors()){
			ModelAndView mv=new ModelAndView("CategoryForm");
			return mv;
		}
		else{
			ModelAndView mv = new ModelAndView("ViewAllCategories");
			if(categoryDao.addCategory(categoryObj)){
				mv.addObject("msg","Category Added Succesfully");
			}
			else{
				mv.addObject("msg","Some problem occured");
			}
			mv.addObject("categoryList",categoryDao.getAllCategories());
			session.setAttribute("categoryList",categoryDao.getAllCategories());
			return mv;
		}
		
	}
	
	@RequestMapping(value="viewAllCategories",method=RequestMethod.GET)
	public ModelAndView getAllCategories(){
		List<Category> categories=categoryDao.getAllCategories();
		ModelAndView mv=new ModelAndView("ViewAllCategories");
		mv.addObject("categoryList",categories);
		return mv;
	}
	
	@RequestMapping(value="updateCategory/{catId}",method=RequestMethod.GET)
	public ModelAndView updateCategory(@PathVariable int catId){
		Category cObj = categoryDao.getCategoryById(catId);
		ModelAndView mv = new ModelAndView("UpdateCateogryForm");
		mv.addObject("categoryObj",cObj);
		return mv;
	}
	
	@RequestMapping(value="updateCategoryProcess",method=RequestMethod.POST)
	public ModelAndView updateCategoryProcess(@ModelAttribute("categoryObj") Category categoryObj){
		categoryDao.updateCategory(categoryObj);
		ModelAndView mv = new ModelAndView("ViewAllCategories");
		mv.addObject("msg","Category Updated Successfully");
		mv.addObject("categoryList",categoryDao.getAllCategories());
		return mv;
	}
	
	@RequestMapping(value="deleteCategory/{catId}",method=RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable int catId){
		categoryDao.deleteCategory(catId);
		
		
		List<Category> categories=categoryDao.getAllCategories();
		
		ModelAndView mv=new ModelAndView("ViewAllCategories");
		mv.addObject("msg","Category deleted Succesfully..");
		mv.addObject("categoryList",categories);
		return mv;
	}
	

}
