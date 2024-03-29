package com.educandoweb.courser.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.courser.entities.User;
import com.educandoweb.courser.services.UserService;

@RestController
@RequestMapping(value = "/users") // Nome
public class UserResource {
	@Autowired // Spring faz a injeção de dependencia
	private UserService service; // dependencia para o service

	@GetMapping
	public ResponseEntity<List<User>> findAll() {// metodo que retorna os meus usuarios
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	// enpoint para buscar um usuario por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// inserir um novo usuario
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build(); // noContent resposta sem conteudo cod 204
	}
	//atualizar um recurso do metodo htttp
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> upadate(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
