package com.educandoweb.courser.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//construtor
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}

}
