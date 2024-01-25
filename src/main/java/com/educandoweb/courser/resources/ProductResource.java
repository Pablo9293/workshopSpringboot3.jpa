package com.educandoweb.courser.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.courser.entities.Product;
import com.educandoweb.courser.services.ProductService;

@RestController
@RequestMapping(value = "/products")  //Nome
public class ProductResource {
	@Autowired // Spring faz a injeção de dependencia
	private ProductService service; //dependencia para o service
	
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){//metodo que retorna os meus usuarios
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
		
	}
	// enpoint para buscar um usuario por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product>findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
