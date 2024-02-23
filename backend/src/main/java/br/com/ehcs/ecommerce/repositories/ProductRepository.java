package br.com.ehcs.ecommerce.repositories;

import br.com.ehcs.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
