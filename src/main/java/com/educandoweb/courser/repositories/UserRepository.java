package com.educandoweb.courser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.courser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
