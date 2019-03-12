package com.frontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.backendpro.dao.CategoryDao;
import com.backendpro.dao.ProductDao;
import com.backendpro.model.Category;
import com.backendpro.model.Product;
import com.backendpro.validator.ProductValidator;


@Controller
public class ProductController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductValidator productValidator;
	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public ModelAndView getSupplierForm(){
		ModelAndView mv = new ModelAndView("ProductForm");
		mv.addObject("productObj",new Product());
		return mv;
		
	}
	
	@RequestMapping(value="/addProductProcess",method=RequestMethod.POST)
	public ModelAndView addSupplierProcess(@Valid @ModelAttribute("productObj")Product productObj, BindingResult result){
		productValidator.validate(productObj, result);
		if(productObj.getpImage().getSize()==0){
			result.rejectValue("pImage","errKey03");
		}
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("ProductForm");
			return mv;
		}
		
		else{
			MultipartFile imageObj=productObj.getpImage();
			String imgName=imageObj.getOriginalFilename();
			
			
			productObj.setImgName(imgName);
			//productDao.addProduct(productObj);
		
			uploadImage(imageObj);
			
			
			ModelAndView mv=new ModelAndView("ViewAllProducts");
			
			if(productDao.addProduct(productObj)){
				mv.addObject("msg","Product Added Succesfully");
			}
			else{
				mv.addObject("msg","Some problem occured");
			}
			mv.addObject("productList", productDao.getAllProducts());
			return mv;
		}
		
		}
		
	@RequestMapping(value="viewAllProducts",method=RequestMethod.GET)
	public ModelAndView getAllProducts(){
		List<Product> products=productDao.getAllProducts();
		ModelAndView mv=new ModelAndView("ViewAllProducts");
		mv.addObject("productList",products);
		return mv;
	}
	
	@RequestMapping(value="updateProduct/{proId}",method=RequestMethod.GET)
	public ModelAndView updateProduct(@PathVariable int proId){
		Product pObj = productDao.getProductById(proId);
		ModelAndView mv = new ModelAndView("UpdateProductForm");
		mv.addObject("productObj",pObj);
		return mv;
	}
	
	@RequestMapping(value="updateProductProcess",method=RequestMethod.POST)
	public ModelAndView updateProductProcess(@Valid @ModelAttribute("productObj") Product productObj, BindingResult result){
		
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("UpdateProductForm");
			return mv;
		}
		
		else{
			MultipartFile mFile=productObj.getpImage();
			
			if(mFile.getSize()==0){
				
				System.out.println("In if");
				int pId=productObj.getProductId();
				
				System.out.println("Product Id" +pId);
				Product p=productDao.getProductById(pId);
				String oldImageName=p.getImgName();
				System.out.println(oldImageName);
				productObj.setImgName(oldImageName);
				
			}
			
			else {
			productObj.setImgName(mFile.getOriginalFilename());
			productDao.updateProduct(productObj);
			
			uploadImage(mFile);
			}
			
			productDao.updateProduct(productObj);
			ModelAndView mv = new ModelAndView("ViewAllProducts");
			mv.addObject("msg","Product Updated Successfully");
			mv.addObject("productList",productDao.getAllProducts());
			return mv;
		}
		
	}
	
	@RequestMapping(value="deleteProduct/{proId}",method=RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable int proId){
		productDao.deleteProduct(proId);
		ModelAndView mv=new ModelAndView("ViewAllProducts");
		mv.addObject("msg","Product deleted Succesfully..");
		mv.addObject("productList",productDao.getAllProducts());
		return mv;
	}
	
	@RequestMapping(value="/getAllProductsByCategory/{cId}",method=RequestMethod.GET)
	public ModelAndView getProductsByCategory(@PathVariable int cId){
		
		List<Product> productsList=productDao.getProductListByCategoryId(cId);
		
		ModelAndView mv=new ModelAndView("ViewAllProductsByCategory");
		mv.addObject("productList",productsList);
		mv.addObject("category", categoryDao.getCategoryById(cId));
		return mv;
	}
	
	private void uploadImage(MultipartFile imageObj){
		String path = session.getServletContext().getRealPath("/");
		System.out.println("filePathString : "+path);
		
		try {
			
			byte[] imageBytes=imageObj.getBytes();
			
			String str=path+"resource\\images\\";
			File file=new File(str);
			if(!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream fos=new FileOutputStream
					(path+"resource\\images\\"+imageObj.getOriginalFilename());
			BufferedOutputStream bos= new BufferedOutputStream(fos);
			
			bos.write(imageBytes);
			bos.close();
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
	
