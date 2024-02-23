package br.com.ehcs.ecommerce.services;

import br.com.ehcs.ecommerce.entities.Product;
import br.com.ehcs.ecommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new IllegalStateException("Entity not found"));
    }

    public Product insert(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product newProduct) {
        try {
            Product oldProduct = productRepository.getOne(id);
            Product updatedProduct = attProduct(oldProduct, newProduct);
            return productRepository.save(updatedProduct);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch(EntityNotFoundException e) {
            throw new EntityNotFoundException("Id not found " + id);
        }
    }

    private Product attProduct(Product oldProduct, Product newProduct) {
        oldProduct.setInternalCode(newProduct.getInternalCode());
        oldProduct.setName(newProduct.getName());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setQuantity(newProduct.getQuantity());
        oldProduct.setPrice(newProduct.getPrice());
        return oldProduct;
    }

}
