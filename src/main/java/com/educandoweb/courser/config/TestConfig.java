package com.educandoweb.courser.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.courser.entities.Category;
import com.educandoweb.courser.entities.Order;
import com.educandoweb.courser.entities.User;
import com.educandoweb.courser.entities.enums.OrderStatus;
import com.educandoweb.courser.repositories.CategoryRepository;
import com.educandoweb.courser.repositories.OrderRepository;
import com.educandoweb.courser.repositories.UserRepository;

@Configuration // configuração epecefica para perfil de teste
@Profile("test")
public class TestConfig implements CommandLineRunner {
	// Declarar um atributo do tipo repository
	@Autowired // instancia userRepository ao tesConfig dependencia
	private UserRepository userRepository;
	
	//Fazer o sid para salvar alguns pedidos na carga inicial do banco
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		// instanciando objetos da categoria repositorio
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		// Salvar no banco as categorias acima chamando:
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
		
		// Instanciar objetos do tipo usuario
		User u1 = new User(null, "Isis Cupertino", "isi@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Pablo Cupertino", "pablo@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAD, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WATTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WATTING_PAYMENT, u1);
		
		//Salvar os usuarios no banco de dados
		userRepository.saveAll(Arrays.asList(u1 , u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));

	}

}
