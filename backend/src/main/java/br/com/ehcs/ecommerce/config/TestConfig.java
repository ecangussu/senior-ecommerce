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

        Product p1 = new Product(1L, 10L, "Iphone", "Celular apple", 10, 5000.0);
        Product p2 = new Product(2L, 20L, "Iphone", "Celular apple", 10, 5000.0);
        Product p3 = new Product(3L, 30L, "Iphone", "Celular apple", 10, 5000.0);
        Product p4 = new Product(4L, 40L, "Iphone", "Celular apple", 10, 5000.0);
        Product p5 = new Product(5L, 50L, "Iphone", "Celular apple", 10, 5000.0);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Order o1 = new Order(1L, "100", "Estevao");
        Order o2 = new Order(2L, "200", "Estevao");
        Order o3 = new Order(3L, "300", "Estevao");

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderProduct oi1 = new OrderProduct(o1, p1, 2);
        OrderProduct oi2 = new OrderProduct(o1, p3, 1);
        OrderProduct oi3 = new OrderProduct(o2, p3, 2);
        OrderProduct oi4 = new OrderProduct(o3, p5, 2);

        orderProductRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }

}
