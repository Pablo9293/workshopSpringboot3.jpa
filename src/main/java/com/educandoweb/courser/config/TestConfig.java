package com.educandoweb.courser.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.courser.entities.Category;
import com.educandoweb.courser.entities.Order;
import com.educandoweb.courser.entities.OrderItem;
import com.educandoweb.courser.entities.Product;
import com.educandoweb.courser.entities.User;
import com.educandoweb.courser.entities.enums.OrderStatus;
import com.educandoweb.courser.repositories.CategoryRepository;
import com.educandoweb.courser.repositories.OrderItemRepositoy;
import com.educandoweb.courser.repositories.OrderRepository;
import com.educandoweb.courser.repositories.ProductRepository;
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
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepositoy orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		// instanciando objetos da categoria repositorio
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		//instanciando objetos da categoria produto
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		// Salvar no banco as categorias acima chamando:
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		//salvando os produtos no banco, chamando os produtos acima:
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		// Produtos associados as suas categorias, cfe desenho do projeto
		p2.getCategories().add(cat1);
		p1.getCategories().add(cat2); 
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		//Salvando as associações
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		
		// Instanciar objetos do tipo usuario
		User u1 = new User(null, "Isis Cupertino", "isi@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Pablo Cupertino", "pablo@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAD, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WATTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WATTING_PAYMENT, u1);
		
		//Salvar os usuarios no banco de dados
		userRepository.saveAll(Arrays.asList(u1 , u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		//objetos instanciados em memoria
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		//seed para salvar no banco
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

	}

}
