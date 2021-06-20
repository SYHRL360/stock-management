package com.The360company.portfolio.inventorymanagement.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{

	private String firstFieldName;
	
	private String secondFieldName;
	
	private String message;
	
	
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		this.firstFieldName = constraintAnnotation.first();
		this.secondFieldName = constraintAnnotation.second();
		this.message = constraintAnnotation.message();
	}



	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		
		try {
			
			Object firstObj = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
			Object secondObj = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);
			
			valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
			
		}catch(Exception ignore) {
			ignore.printStackTrace();
		}
		
		if(!valid) {
			context.buildConstraintViolationWithTemplate(message)
					.addPropertyNode(firstFieldName)
					.addConstraintViolation()
					.disableDefaultConstraintViolation();
		}
		
		return valid;
	}

}
