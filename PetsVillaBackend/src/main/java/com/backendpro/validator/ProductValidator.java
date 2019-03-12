package com.backendpro.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.backendpro.model.Product;

@Component
public class ProductValidator implements Validator {

	public boolean supports(Class clazz) {
		return Product.class.isAssignableFrom(clazz);
		
	}

	public void validate(Object target, Errors errors) {
		Product pObj = (Product) target;
		if(pObj.getCategoryId()==0){
			errors.rejectValue("categoryId", "errKey01");
		}
		if(pObj.getSupplierId()==0){
			errors.rejectValue("supplierId", "errKey02");
		}

	}

}
