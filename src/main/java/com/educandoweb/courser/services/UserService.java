package com.educandoweb.courser.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.courser.entities.User;
import com.educandoweb.courser.repositories.UserRepository;
import com.educandoweb.courser.services.exceptions.ResourceNotFoundException;
@Service // registra uma classe de servico como um componente do spring
public class UserService {

	//Dependencia o userRepository
	@Autowired
	private UserRepository repository;
	
	//metod que retorna todos os usuarios do banco
	public List<User> findAll(){ // operacao na camada de serviço
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //tenta dar o get, se não tiver usuario,lanca a esceção
	}
	//salvar no banco um dado usuario
	
	public User insert(User obj){// retorna o usuario salvo
         return repository.save(obj);
	} 
	
	//Deleção de usuario
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	//atualizar um dado usuario no banco
	public User update(Long id , User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity , obj);
		return repository.save(entity);
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}


