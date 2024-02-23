package br.com.ehcs.ecommerce.repositories;

import br.com.ehcs.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
