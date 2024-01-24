package com.educandoweb.courser.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.courser.entities.User;
import com.educandoweb.courser.services.UserService;

@RestController
@RequestMapping(value = "/users")  //Nome
public class UserResource {
	@Autowired // Spring faz a injeção de dependencia
	private UserService service; //dependencia para o service
	
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){//metodo que retorna os meus usuarios
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
		
	}
	// enpoint para buscar um usuario por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<User>findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
