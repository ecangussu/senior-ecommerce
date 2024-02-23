package br.com.ehcs.ecommerce.services;

import br.com.ehcs.ecommerce.entities.Order;
import br.com.ehcs.ecommerce.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new IllegalStateException("Entity not found"));
    }

    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Long id, Order newOrder) {
        try {
            Order oldOrder = orderRepository.getOne(id);
            Order updatedOrder = attOrder(oldOrder, newOrder);
            return orderRepository.save(updatedOrder);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch(EntityNotFoundException e) {
            throw new EntityNotFoundException("Id not found " + id);
        }
    }

    private Order attOrder(Order oldOrder, Order newOrder) {
        oldOrder.setNumber(newOrder.getNumber());
        oldOrder.setCustomerName(newOrder.getCustomerName());
        oldOrder.setDate(newOrder.getDate());
        return oldOrder;
    }

}
