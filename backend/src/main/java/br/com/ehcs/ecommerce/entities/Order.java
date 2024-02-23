package br.com.ehcs.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number = UUID.randomUUID().toString();

    private String customerName;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderProduct> orderProducts = new HashSet<>();

    private Double finalValue;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant date = Instant.now();

    public void setFinalValue() {
        for(OrderProduct orderProduct : orderProducts) {
            this.finalValue+= orderProduct.getProduct().getPrice() * orderProduct.getQuantity();
        }
    }
}
