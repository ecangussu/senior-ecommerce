package br.com.ehcs.ecommerce.entities;
import br.com.ehcs.ecommerce.entities.PK.OrderProductPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order_product")
@Data
@NoArgsConstructor
public class OrderProduct {

    @EmbeddedId
    private OrderProductPK id = new OrderProductPK();

    private Integer quantity;

    public OrderProduct(Product product, Order order, Integer quantity) {
        id.setProduct(product);
        id.setOrder(order);
        this.quantity = quantity;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    @JsonIgnore
    public Order getOder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

}
