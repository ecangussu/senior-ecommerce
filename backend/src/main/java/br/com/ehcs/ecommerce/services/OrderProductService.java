package br.com.ehcs.ecommerce.services;

import br.com.ehcs.ecommerce.entities.OrderProduct;
import br.com.ehcs.ecommerce.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProduct insert(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

}
