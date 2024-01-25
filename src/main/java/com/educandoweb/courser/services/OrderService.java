package com.educandoweb.courser.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.courser.entities.Order;
import com.educandoweb.courser.repositories.OrderRepository;
@Service // registra uma classe de servico como um componente do spring
public class OrderService {

	//Dependencia o userRepository
	@Autowired
	private OrderRepository repository;
	
	//metod que retorna todos os usuarios do banco
	public List<Order> findAll(){ // operacao na camada de serviço
		return repository.findAll();
	}
	public Order findById(Long Id) {
		Optional<Order> obj = repository.findById(Id);
		return obj.get();
	}
}

