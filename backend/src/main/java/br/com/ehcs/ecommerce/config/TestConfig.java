package br.com.ehcs.ecommerce.config;

import br.com.ehcs.ecommerce.entities.Order;
import br.com.ehcs.ecommerce.entities.OrderProduct;
import br.com.ehcs.ecommerce.entities.Product;
import br.com.ehcs.ecommerce.repositories.OrderProductRepository;
import br.com.ehcs.ecommerce.repositories.OrderRepository;
import br.com.ehcs.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product("Iphone 13", "Celular da Apple", 10, 5000.0);
        Product p2 = new Product("Galaxy a34", "Celular da Samsung", 90, 1400.0);
        Product p3 = new Product("Moto g54", "Celular da Motorola", 37, 1200.0);
        Product p4 = new Product("Redmi Note 12", "Celular da Xiaomi", 25, 1000.0);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        Order o1 = new Order("João de Souza", "123.456.789.10", "joao@gmail.com");
        Order o2 = new Order("José da Silva", "098.765.432.10", "jose@hotmail.com");
        Order o3 = new Order("Maria do Carmo", "101.202.303.44", "maria_do_carmo@yahoo.com.br");

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderProduct oi1 = new OrderProduct(o1, p1, 2, p1.getPrice());
        OrderProduct oi2 = new OrderProduct(o1, p3, 1, p3.getPrice());
        OrderProduct oi3 = new OrderProduct(o2, p3, 1, p3.getPrice());
        OrderProduct oi4 = new OrderProduct(o3, p1, 1, p1.getPrice());
        OrderProduct oi5 = new OrderProduct(o3, p2, 1, p2.getPrice());
        OrderProduct oi6 = new OrderProduct(o3, p4, 3, p4.getPrice());

        orderProductRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5, oi6));
    }

}
