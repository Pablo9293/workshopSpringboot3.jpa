package com.educandoweb.courser.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.courser.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // intercepta as exceções para um possível tratatmento
public class ResourceExceptionHandler {
	
	//Tratamentos
	@ExceptionHandler(ResourceNotFoundException.class) // intercepta a exceção para cair aqui
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		//implementação do tratamento
		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;// error 4040
		
		//Instanciar o objeto da classe criada
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}

}
