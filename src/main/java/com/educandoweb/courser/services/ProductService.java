package com.educandoweb.courser.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.courser.entities.Product;
import com.educandoweb.courser.repositories.ProductRepository;
@Service // registra uma classe de servico como um componente do spring
public class ProductService {

	//Dependencia o userRepository
	@Autowired
	private ProductRepository repository;
	
	//metod que retorna todos os usuarios do banco
	public List<Product> findAll(){ // operacao na camada de serviço
		return repository.findAll();
	}
	public Product findById(Long Id) {
		Optional<Product> obj = repository.findById(Id);
		return obj.get();
	}
}

