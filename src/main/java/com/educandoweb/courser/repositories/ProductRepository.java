package com.educandoweb.courser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.courser.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
