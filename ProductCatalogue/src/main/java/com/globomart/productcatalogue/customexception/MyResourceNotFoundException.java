package com.globomart.productcatalogue.customexception;

public class MyResourceNotFoundException extends RuntimeException {
	
	public MyResourceNotFoundException(String errorMessage){
		super(errorMessage);
	}
}
