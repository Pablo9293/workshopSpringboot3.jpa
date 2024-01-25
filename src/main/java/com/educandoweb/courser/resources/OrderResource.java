package com.educandoweb.courser.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.courser.entities.Order;
import com.educandoweb.courser.services.OrderService;

@RestController
@RequestMapping(value = "/orders")  //Nome
public class OrderResource {
	@Autowired // Spring faz a injeção de dependencia
	private OrderService service; //dependencia para o service
	
	
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){//metodo que retorna os meus usuarios
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
		
	}
	// enpoint para buscar um usuario por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
