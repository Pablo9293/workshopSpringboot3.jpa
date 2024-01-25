package com.educandoweb.courser.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.courser.entities.Category;
import com.educandoweb.courser.repositories.CategoryRepository;

@Service // registra uma classe de servico como um componente do spring
public class CategoryService {

	// Dependencia o userRepository
	@Autowired
	private CategoryRepository repository;

	// metod que retorna todos os usuarios do banco
	public List<Category> findAll() { // operacao na camada de serviço
		return repository.findAll();
	}

	public Category findById(Long Id) {
		Optional<Category> obj = repository.findById(Id);
		return obj.get();
	}
}
