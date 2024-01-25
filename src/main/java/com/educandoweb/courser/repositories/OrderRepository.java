package com.educandoweb.courser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.courser.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
