package com.educandoweb.courser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.courser.entities.OrderItem;

public interface OrderItemRepositoy extends JpaRepository<OrderItem ,Long> {

}
