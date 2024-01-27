package com.educandoweb.courser.services.exceptions;

public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//construtor com string
	
	public DatabaseException(String msg) {
		super(msg);
		
	}

}
