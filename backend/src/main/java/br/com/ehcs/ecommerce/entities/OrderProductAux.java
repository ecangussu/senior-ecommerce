package br.com.ehcs.ecommerce.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderProductAux {

    private Order order;
    private List<ProductAux> productAux = new ArrayList<>();

}
