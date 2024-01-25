package com.educandoweb.courser.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.courser.entities.Category;
import com.educandoweb.courser.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")  //Nome
public class CategoryResource {
	@Autowired // Spring faz a injeção de dependencia
	private CategoryService service; //dependencia para o service
	
	
	// Endpoint para buscar todas as categorias
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){//metodo que retorna os meus usuarios
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
		
	}
	// enpoint para buscar um usuario por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category>findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
