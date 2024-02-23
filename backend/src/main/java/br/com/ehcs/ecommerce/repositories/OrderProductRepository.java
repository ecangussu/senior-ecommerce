package br.com.ehcs.ecommerce.repositories;

import br.com.ehcs.ecommerce.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
