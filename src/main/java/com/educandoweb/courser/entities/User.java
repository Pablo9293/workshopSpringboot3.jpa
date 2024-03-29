package com.educandoweb.courser.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb user") //palavra reservada user no banco h2
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// uma anotacao para especificar a chave primaria
	@Id
	// chave numerica autoincrement
	@GeneratedValue(strategy = GenerationType.IDENTITY)//definicao de estrategia de autoincremento
	private Long id;   // Associaçoes
	private String name;
	private String email;
	private String phone;
	private String passwword;
	@JsonIgnore
	@OneToMany(mappedBy ="client") // do outro lado da associação esta mapeado pelo atributo client 1:m
	private List<Order> orders = new ArrayList<>(); // Instancia esta associação pois e uma lista
	
	
	
	public User() {
		
	}

	public User(Long id, String name, String email, String phone, String passwword) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.passwword = passwword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPasswword() {
		return passwword;
	}

	public void setPasswword(String passwword) {
		this.passwword = passwword;
	}
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	

}
