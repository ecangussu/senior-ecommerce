package br.com.ehcs.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.AccessLevel;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Setter(AccessLevel.NONE)
    private String number = UUID.randomUUID().toString();

    private String customerName;

    private String cpf;

    private String email;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Setter(AccessLevel.NONE)
    private Instant date = Instant.now();

    @OneToMany(mappedBy = "id.order")
    @Setter(AccessLevel.NONE)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Order(String customerName, String cpf, String email) {
        this.customerName = customerName;
        this.cpf = cpf;
        this.email = email;
    }

    public Double getTotal() {
        double total = 0.0;
        for(OrderProduct orderProduct : orderProducts) {
            total+= orderProduct.getSubTotal();
        }
        return total;
    }

}
