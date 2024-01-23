package com.educandoweb.courser.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.courser.entities.User;

@RestController
@RequestMapping(value ="/users")  //Nome
public class UserResource {
	// criar um metodo para acessar os usuarios
	
	
	@GetMapping
	public ResponseEntity<User>findAll(){//metodo que retorna os meus usuarios
		User u = new User(1L, "Isis", "isi@gmail.com", "981442481", "12345");
		return ResponseEntity.ok().body(u);
		
		
	}

}
