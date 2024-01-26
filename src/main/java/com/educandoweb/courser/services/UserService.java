package com.educandoweb.courser.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.courser.entities.User;
import com.educandoweb.courser.repositories.UserRepository;
@Service // registra uma classe de servico como um componente do spring
public class UserService {

	//Dependencia o userRepository
	@Autowired
	private UserRepository repository;
	
	//metod que retorna todos os usuarios do banco
	public List<User> findAll(){ // operacao na camada de serviço
		return repository.findAll();
	}
	public User findById(Long Id) {
		Optional<User> obj = repository.findById(Id);
		return obj.get();
	}
	//salvar no banco um dado usuario
	
	public User insert(User obj){// retorna o usuario salvo
         return repository.save(obj);
	}  
}


