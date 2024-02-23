package br.com.ehcs.ecommerce.entities.PK;

import br.com.ehcs.ecommerce.entities.Order;
import br.com.ehcs.ecommerce.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class OrderProductPK {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
