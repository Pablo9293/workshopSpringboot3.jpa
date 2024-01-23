package com.educandoweb.courser.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.courser.entities.User;
import com.educandoweb.courser.repositories.UserRepository;

@Configuration // configuração epecefica para perfil de teste
@Profile("test")
public class TestConfig implements CommandLineRunner {
	// Declarar um atributo do tipo repository
	@Autowired // instancia userRepository ao tesConfig dependencia
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// Instanciar objetos do tipo usuario
		User u1 = new User(null, "Isis Cupertino", "isi@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Pablo Cupertino", "pablo@gmail.com", "977777777", "123456");
		
		//Salvar os usuarios no banco de dados
		userRepository.saveAll(Arrays.asList(u1 , u2));

	}

}
