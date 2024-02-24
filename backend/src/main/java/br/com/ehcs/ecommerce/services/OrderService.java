package br.com.ehcs.ecommerce.services;

import br.com.ehcs.ecommerce.entities.Order;
import br.com.ehcs.ecommerce.entities.Product;
import br.com.ehcs.ecommerce.entities.OrderProduct;
import br.com.ehcs.ecommerce.entities.OrderProductAux;
import br.com.ehcs.ecommerce.entities.ProductAux;
import br.com.ehcs.ecommerce.repositories.OrderProductRepository;
import br.com.ehcs.ecommerce.repositories.OrderRepository;
import br.com.ehcs.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new IllegalStateException("Pedido inexistente!"));
    }

    public Order insert(OrderProductAux orderProductAux) {
        orderRepository.save(orderProductAux.getOrder());
        for(ProductAux productId : orderProductAux.getProductAux()) {
            Product product = productRepository.findById(productId.getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            if(productId.getQuantity() < product.getQuantity()) {
                product.setQuantity(product.getQuantity() - productId.getQuantity());
                productRepository.save(product);
                OrderProduct orderProduct = new OrderProduct(orderProductAux.getOrder(), product, productId.getQuantity(), product.getPrice());
                orderProductRepository.save(orderProduct);
                orderProductAux.getOrder().getOrderProducts().add(orderProduct);
            } else {
                throw new IllegalStateException("Quantidade pedida maior do que em estoque!");
            }
        }
        return orderRepository.save(orderProductAux.getOrder());
    }

}
